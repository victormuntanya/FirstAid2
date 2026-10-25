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
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.LocalPolice
import androidx.compose.material.icons.filled.MedicalServices
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstaid.data.model.DistrictHelpline
import com.example.firstaid.data.model.Language
import com.example.firstaid.data.model.UserProfile
import com.example.firstaid.ui.components.triggerPhoneCall
import com.example.firstaid.ui.theme.CallGreen
import com.example.firstaid.ui.theme.DarkSlateHeader
import com.example.firstaid.ui.theme.EmergencyRed
import com.example.firstaid.ui.theme.PrimaryTeal

@Composable
fun HelplinesScreen(
    userProfile: UserProfile,
    districts: List<DistrictHelpline>,
    onSelectDistrict: (String) -> Unit,
    onOpenReportModal: () -> Unit,
    onCheckContentUpdates: () -> Unit
) {
    val context = LocalContext.current
    val lang = userProfile.preferredLanguage
    val scale = userProfile.fontScale

    val selectedDistrictHelpline = districts.find {
        it.districtName.equals(userProfile.selectedDistrict, ignoreCase = true)
    } ?: districts.first()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(top = 16.dp, bottom = 90.dp)
    ) {
        // District Helplines Hero Banner (matching Screen 2 in Capture.PNG)
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
                        text = if (lang == Language.CHICHEWA) "Manambala Azaumoyo Pa Boma" else "District Emergency Directory",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = (18 * scale).sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = if (lang == Language.CHICHEWA)
                            "Sankhani Boma lomwe muli pafupi pofuna kupeza Chipatala, Apolisi ndi Ambulansi zotetezeka."
                        else
                            "District level emergency contacts with single-tap calling capability.",
                        color = Color(0xFFB0BEC5),
                        fontSize = (12 * scale).sp
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    // Online Update Content Button (FR10)
                    OutlinedButton(
                        onClick = onCheckContentUpdates,
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                        border = ButtonDefaults.outlinedButtonBorder.copy(brush = androidx.compose.ui.graphics.SolidColor(Color(0xFF80CBC4))),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Refresh, contentDescription = "Update", tint = Color(0xFF80CBC4))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = if (lang == Language.CHICHEWA) "Tsitsani Manambala Zatsopano (Update Online)" else "Refresh Helplines Online",
                            fontSize = (11 * scale).sp
                        )
                    }
                }
            }
        }

        // Horizontal District Selector Pills
        item {
            Column(modifier = Modifier.padding(bottom = 16.dp)) {
                Text(
                    text = if (lang == Language.CHICHEWA) "Sankhani Boma Lanu (Select District):" else "Select District:",
                    fontWeight = FontWeight.Bold,
                    fontSize = (15 * scale).sp,
                    color = DarkSlateHeader
                )
                Spacer(modifier = Modifier.height(10.dp))

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(districts) { dist ->
                        val isSelected = dist.districtName.equals(userProfile.selectedDistrict, ignoreCase = true)
                        Surface(
                            shape = RoundedCornerShape(20.dp),
                            color = if (isSelected) PrimaryTeal else Color(0xFFE2E8F0),
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .clickable { onSelectDistrict(dist.districtName) }
                        ) {
                            Text(
                                text = dist.districtName,
                                color = if (isSelected) Color.White else Color(0xFF334155),
                                fontSize = (12 * scale).sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
                            )
                        }
                    }
                }
            }
        }

        // Active District Selected Banner (Clean banner without the red "Ripoti Nambala" button)
        item {
            Surface(
                color = Color(0xFFE0F2F1),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = "Boma la ${selectedDistrictHelpline.districtName}",
                            fontWeight = FontWeight.Bold,
                            fontSize = (16 * scale).sp,
                            color = PrimaryTeal
                        )
                        Text(
                            text = "${selectedDistrictHelpline.region} • Manambala Yotsimikizidwa (${selectedDistrictHelpline.verifiedDate})",
                            fontSize = (11 * scale).sp,
                            color = Color(0xFF004D40)
                        )
                    }
                }
            }
        }

        // Emergency Contact Cards (Matching Screen 2 in Capture.PNG)

        // 1. Hospital Card
        item {
            HelplineContactCard(
                title = selectedDistrictHelpline.hospitalName,
                subtitle = if (lang == Language.CHICHEWA) "Chipatala Cha Boma (District Hospital)" else "District Hospital",
                phoneNumber = selectedDistrictHelpline.hospitalNumber,
                icon = Icons.Default.LocalHospital,
                iconBgColor = PrimaryTeal,
                fontScale = scale,
                lang = lang,
                onCall = { triggerPhoneCall(context, selectedDistrictHelpline.hospitalNumber) }
            )
            Spacer(modifier = Modifier.height(12.dp))
        }

        // 2. Police Card
        item {
            HelplineContactCard(
                title = selectedDistrictHelpline.policeName,
                subtitle = if (lang == Language.CHICHEWA) "Apolisi A Boma (District Police)" else "Police Dispatch",
                phoneNumber = selectedDistrictHelpline.policeNumber,
                icon = Icons.Default.LocalPolice,
                iconBgColor = DarkSlateHeader,
                fontScale = scale,
                lang = lang,
                onCall = { triggerPhoneCall(context, selectedDistrictHelpline.policeNumber) }
            )
            Spacer(modifier = Modifier.height(12.dp))
        }

        // 3. Ambulance Card
        item {
            HelplineContactCard(
                title = if (lang == Language.CHICHEWA) "Galimoto Ya Odwala (Ambulance Service)" else "Ambulance Dispatch",
                subtitle = "National & District Emergency Response",
                phoneNumber = selectedDistrictHelpline.ambulanceNumber,
                icon = Icons.Default.MedicalServices,
                iconBgColor = EmergencyRed,
                fontScale = scale,
                lang = lang,
                onCall = { triggerPhoneCall(context, selectedDistrictHelpline.ambulanceNumber) }
            )
            Spacer(modifier = Modifier.height(12.dp))
        }

        // 4. Malawi Red Cross Card
        item {
            HelplineContactCard(
                title = "Malawi Red Cross Society",
                subtitle = if (lang == Language.CHICHEWA) "Thandizo la Chinchunzi & Ngozi (Red Cross Hotline)" else "Emergency First Aid Support",
                phoneNumber = selectedDistrictHelpline.redCrossNumber,
                icon = Icons.Default.Shield,
                iconBgColor = Color(0xFFC62828),
                fontScale = scale,
                lang = lang,
                onCall = { triggerPhoneCall(context, selectedDistrictHelpline.redCrossNumber) }
            )
        }
    }
}

@Composable
fun HelplineContactCard(
    title: String,
    subtitle: String,
    phoneNumber: String,
    icon: ImageVector,
    iconBgColor: Color,
    fontScale: Float,
    lang: Language,
    onCall: () -> Unit
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
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape)
                            .background(iconBgColor),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = title,
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = title,
                            fontWeight = FontWeight.Bold,
                            fontSize = (15 * fontScale).sp,
                            color = DarkSlateHeader
                        )
                        Text(
                            text = subtitle,
                            fontSize = (11 * fontScale).sp,
                            color = Color.Gray
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Phone Number & One-Tap Call Button
            Surface(
                color = Color(0xFFF8FAFC),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = if (lang == Language.CHICHEWA) "Nambala Yoyimbira:" else "Contact Number:",
                            fontSize = (10 * fontScale).sp,
                            color = Color.Gray
                        )
                        Text(
                            text = phoneNumber,
                            fontWeight = FontWeight.Bold,
                            fontSize = (15 * fontScale).sp,
                            color = DarkSlateHeader
                        )
                    }

                    Button(
                        onClick = onCall,
                        colors = ButtonDefaults.buttonColors(containerColor = CallGreen),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Call, contentDescription = "Call", modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = if (lang == Language.CHICHEWA) "Yimbani" else "Call Now",
                            fontWeight = FontWeight.Bold,
                            fontSize = (12 * fontScale).sp
                        )
                    }
                }
            }
        }
    }
}
