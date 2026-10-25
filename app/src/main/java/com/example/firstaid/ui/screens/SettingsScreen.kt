package com.example.firstaid.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.TextFormat
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstaid.data.model.DistrictHelpline
import com.example.firstaid.data.model.Language
import com.example.firstaid.data.model.ThemeMode
import com.example.firstaid.data.model.UserProfile
import com.example.firstaid.ui.theme.DarkSlateHeader
import com.example.firstaid.ui.theme.PrimaryTeal

@Composable
fun SettingsScreen(
    userProfile: UserProfile,
    districts: List<DistrictHelpline>,
    onSelectThemeMode: (ThemeMode) -> Unit,
    onSelectLanguage: (Language) -> Unit,
    onSelectFontScale: (Float) -> Unit,
    onSelectDistrict: (String) -> Unit,
    onOpenAuthModal: () -> Unit
) {
    val lang = userProfile.preferredLanguage
    val scale = userProfile.fontScale

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(top = 16.dp, bottom = 90.dp)
    ) {
        // Settings Hero Header
        item {
            Card(
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = DarkSlateHeader),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text(
                        text = if (lang == Language.CHICHEWA) "Zokonda & Maonekedwe" else "Settings & Customization",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = (18 * scale).sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = if (lang == Language.CHICHEWA)
                            "Sinthani maonekedwe a Pulogalamuyi, Chiyankhulo, Saizi ya Mawu, ndi Boma lanu."
                        else
                            "Customize app theme, language, accessibility text size, and default district location.",
                        color = Color(0xFFB0BEC5),
                        fontSize = (12 * scale).sp
                    )
                }
            }
        }

        // 1. Theme Setting Card
        item {
            SettingSectionCard(
                title = if (lang == Language.CHICHEWA) "Maonekedwe (Theme / Color)" else "App Theme",
                icon = Icons.Default.Palette,
                fontScale = scale
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    SettingOptionChip(
                        title = if (lang == Language.CHICHEWA) "Za Foni (Auto)" else "System",
                        isSelected = userProfile.themeMode == ThemeMode.SYSTEM,
                        onClick = { onSelectThemeMode(ThemeMode.SYSTEM) },
                        fontScale = scale,
                        modifier = Modifier.weight(1f)
                    )
                    SettingOptionChip(
                        title = if (lang == Language.CHICHEWA) "Yoyera (Light)" else "Light",
                        isSelected = userProfile.themeMode == ThemeMode.LIGHT,
                        onClick = { onSelectThemeMode(ThemeMode.LIGHT) },
                        fontScale = scale,
                        modifier = Modifier.weight(1f)
                    )
                    SettingOptionChip(
                        title = if (lang == Language.CHICHEWA) "Yakuda (Dark)" else "Dark",
                        isSelected = userProfile.themeMode == ThemeMode.DARK,
                        onClick = { onSelectThemeMode(ThemeMode.DARK) },
                        fontScale = scale,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            Spacer(modifier = Modifier.height(14.dp))
        }

        // 2. Language Setting Card
        item {
            SettingSectionCard(
                title = if (lang == Language.CHICHEWA) "Chiyankhulo (Language)" else "Language",
                icon = Icons.Default.Language,
                fontScale = scale
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    SettingOptionChip(
                        title = "Chichewa",
                        isSelected = userProfile.preferredLanguage == Language.CHICHEWA,
                        onClick = { onSelectLanguage(Language.CHICHEWA) },
                        fontScale = scale,
                        modifier = Modifier.weight(1f)
                    )
                    SettingOptionChip(
                        title = "English",
                        isSelected = userProfile.preferredLanguage == Language.ENGLISH,
                        onClick = { onSelectLanguage(Language.ENGLISH) },
                        fontScale = scale,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            Spacer(modifier = Modifier.height(14.dp))
        }

        // 3. Font Size / Accessibility Setting Card
        item {
            SettingSectionCard(
                title = if (lang == Language.CHICHEWA) "Saizi ya Mawu (Text Size)" else "Text Size & Accessibility",
                icon = Icons.Default.TextFormat,
                fontScale = scale
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    SettingOptionChip(
                        title = if (lang == Language.CHICHEWA) "Yachibadwa" else "Normal",
                        isSelected = userProfile.fontScale == 1.0f,
                        onClick = { onSelectFontScale(1.0f) },
                        fontScale = scale,
                        modifier = Modifier.weight(1f)
                    )
                    SettingOptionChip(
                        title = if (lang == Language.CHICHEWA) "Aakulu" else "Large",
                        isSelected = userProfile.fontScale == 1.25f,
                        onClick = { onSelectFontScale(1.25f) },
                        fontScale = scale,
                        modifier = Modifier.weight(1f)
                    )
                    SettingOptionChip(
                        title = if (lang == Language.CHICHEWA) "Aakulu +" else "XL",
                        isSelected = userProfile.fontScale == 1.5f,
                        onClick = { onSelectFontScale(1.5f) },
                        fontScale = scale,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            Spacer(modifier = Modifier.height(14.dp))
        }

        // 4. District Location Selector
        item {
            SettingSectionCard(
                title = if (lang == Language.CHICHEWA) "Boma Lanu (District Location)" else "Default District Location",
                icon = Icons.Default.LocationOn,
                fontScale = scale
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(districts) { dist ->
                        val isSelected = dist.districtName.equals(userProfile.selectedDistrict, ignoreCase = true)
                        SettingOptionChip(
                            title = dist.districtName,
                            isSelected = isSelected,
                            onClick = { onSelectDistrict(dist.districtName) },
                            fontScale = scale
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(14.dp))
        }

        // 5. Account & Security Card
        item {
            SettingSectionCard(
                title = if (lang == Language.CHICHEWA) "Akaunti ya Foni (Phone Verification)" else "Phone Account Status",
                icon = Icons.Default.Shield,
                fontScale = scale
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = if (userProfile.isVerified)
                                "Foni Yatsimikizidwa: ${userProfile.phoneNumber}"
                            else
                                (if (lang == Language.CHICHEWA) "Munanena foni koma simunatsimikize." else "Phone not verified yet."),
                            fontWeight = FontWeight.Bold,
                            fontSize = (13 * scale).sp,
                            color = if (userProfile.isVerified) Color(0xFF1B5E20) else Color(0xFF004D40)
                        )
                        Text(
                            text = if (lang == Language.CHICHEWA) "Malinga ndi FR1, simusowa imelo iliyonse." else "Pursuant to FR1, no email registration is required.",
                            fontSize = (11 * scale).sp,
                            color = Color.Gray
                        )
                    }

                    Button(
                        onClick = onOpenAuthModal,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (userProfile.isVerified) Color(0xFF1B5E20) else Color(0xFF00695C)
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(
                            imageVector = if (userProfile.isVerified) Icons.Default.CheckCircle else Icons.Default.Phone,
                            contentDescription = "Auth",
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = if (userProfile.isVerified) "Yatsimikizidwa" else "Lembetsani",
                            fontSize = (11 * scale).sp
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(14.dp))
        }

        // 6. About App & Health Disclaimer Card
        item {
            SettingSectionCard(
                title = if (lang == Language.CHICHEWA) "Za Pulogalamuyi (About First Aid MA)" else "About & Health Disclaimer",
                icon = Icons.Default.Info,
                fontScale = scale
            ) {
                Column {
                    Text(
                        text = "First Aid MA — Chichewa First Aid Mobile App for Malawi",
                        fontWeight = FontWeight.Bold,
                        fontSize = (13 * scale).sp,
                        color = DarkSlateHeader
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = if (lang == Language.CHICHEWA)
                            "• Version 1.0 (2026)\n• Nkhani zonse za pa foni zimatsimikizidwa ndi Malawi Red Cross Society & unduna wa zaumoyo.\n• Imapereka thandizo la offline pa nthawi ya ngozi opanda intaneti."
                        else
                            "• Version 1.0 (2026)\n• Prepared and reviewed with health professionals (Malawi Red Cross Society).\n• Fully functional without internet connectivity after installation.",
                        fontSize = (11 * scale).sp,
                        color = Color(0xFF334155),
                        lineHeight = (17 * scale).sp
                    )
                }
            }
        }
    }
}

@Composable
fun SettingSectionCard(
    title: String,
    icon: ImageVector,
    fontScale: Float,
    content: @Composable () -> Unit
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(20.dp))
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 12.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFE0F2F1)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = title,
                        tint = PrimaryTeal,
                        modifier = Modifier.size(18.dp)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = (14 * fontScale).sp,
                    color = DarkSlateHeader
                )
            }

            content()
        }
    }
}

@Composable
fun SettingOptionChip(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    fontScale: Float,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = if (isSelected) PrimaryTeal else Color(0xFFF1F5F9),
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .border(
                1.dp,
                if (isSelected) PrimaryTeal else Color(0xFFCBD5E1),
                RoundedCornerShape(16.dp)
            )
    ) {
        Box(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title,
                color = if (isSelected) Color.White else Color(0xFF334155),
                fontSize = (12 * fontScale).sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
            )
        }
    }
}
