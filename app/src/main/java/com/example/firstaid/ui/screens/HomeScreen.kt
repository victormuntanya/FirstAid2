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
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstaid.data.model.EmergencyCategory
import com.example.firstaid.data.model.FirstAidGuide
import com.example.firstaid.data.model.Language
import com.example.firstaid.data.model.UserProfile
import com.example.firstaid.ui.theme.DarkSlateHeader
import com.example.firstaid.ui.theme.EmergencyRed
import com.example.firstaid.ui.theme.LightTealContainer
import com.example.firstaid.ui.theme.PrimaryTeal

@Composable
fun HomeScreen(
    userProfile: UserProfile,
    searchQuery: String,
    selectedCategory: EmergencyCategory?,
    guides: List<FirstAidGuide>,
    onSearchQueryChange: (String) -> Unit,
    onSelectCategory: (EmergencyCategory?) -> Unit,
    onSelectGuide: (FirstAidGuide) -> Unit,
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
        // Hero Card matching Capture.PNG design
        item {
            Card(
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = DarkSlateHeader),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(18.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = if (lang == Language.CHICHEWA) "Moni! Ndikuthandizani Bwanji Lero?" else "Hi! How Can I Help You Today?",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = (17 * scale).sp
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = if (lang == Language.CHICHEWA) "Sankhani ngozi kapena chithandizo chadzidzidzi pansipa." else "Select emergency guidance or search below.",
                                color = Color(0xFFB0BEC5),
                                fontSize = (11 * scale).sp
                            )
                        }

                        Box(
                            modifier = Modifier
                                .size(44.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF00897B)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.LocalHospital,
                                contentDescription = "Hospital",
                                tint = Color.White,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Compact Search Bar with high-contrast text color
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = onSearchQueryChange,
                        placeholder = {
                            Text(
                                text = if (lang == Language.CHICHEWA) "Sakasaka za thandizo (Bleeding, Burns...)" else "Search guidance (Bleeding, Burns...)",
                                color = Color(0xFF64748B),
                                fontSize = (12 * scale).sp
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search",
                                tint = PrimaryTeal,
                                modifier = Modifier.size(20.dp)
                            )
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(14.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            focusedBorderColor = PrimaryTeal,
                            unfocusedBorderColor = Color.Transparent,
                            focusedTextColor = Color(0xFF0F172A),
                            unfocusedTextColor = Color(0xFF0F172A)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp)
                    )
                }
            }
        }

        // Verification Banner if user not verified
        if (!userProfile.isVerified) {
            item {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFE0F2F1)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                        .border(1.dp, Color(0xFF80CBC4), RoundedCornerShape(16.dp))
                ) {
                    Row(
                        modifier = Modifier
                            .padding(12.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Shield,
                                contentDescription = "Verification",
                                tint = Color(0xFF00695C),
                                modifier = Modifier.size(26.dp)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Column {
                                Text(
                                    text = if (lang == Language.CHICHEWA) "Chitsimikizo cha Foni" else "Phone Sign-Up",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = (13 * scale).sp,
                                    color = Color(0xFF004D40)
                                )
                                Text(
                                    text = if (lang == Language.CHICHEWA) "Lembetsani ndi foni opanda email." else "Register phone without email.",
                                    fontSize = (11 * scale).sp,
                                    color = Color(0xFF00695C)
                                )
                            }
                        }

                        Button(
                            onClick = onOpenAuthModal,
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00695C)),
                            shape = RoundedCornerShape(12.dp),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                        ) {
                            Icon(imageVector = Icons.Default.Phone, contentDescription = "Sign Up", modifier = Modifier.size(14.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = if (lang == Language.CHICHEWA) "Lembetsani" else "Sign Up",
                                fontSize = (11 * scale).sp
                            )
                        }
                    }
                }
            }
        }

        // Category Filter Horizontal Scroll
        item {
            Column(modifier = Modifier.padding(bottom = 16.dp)) {
                Text(
                    text = if (lang == Language.CHICHEWA) "Magulu Aza Ngozi (Emergency Categories):" else "Emergency Categories:",
                    fontWeight = FontWeight.Bold,
                    fontSize = (15 * scale).sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(10.dp))

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    item {
                        CategoryChip(
                            title = if (lang == Language.CHICHEWA) "Zonse (All)" else "All",
                            isSelected = selectedCategory == null,
                            onClick = { onSelectCategory(null) },
                            fontScale = scale
                        )
                    }

                    items(EmergencyCategory.entries) { cat ->
                        CategoryChip(
                            title = if (lang == Language.CHICHEWA) cat.titleChichewa else cat.titleEnglish,
                            isSelected = selectedCategory == cat,
                            onClick = { onSelectCategory(cat) },
                            fontScale = scale
                        )
                    }
                }
            }
        }

        // Section Title: Offline First Aid Guides
        item {
            Text(
                text = if (lang == Language.CHICHEWA) "Bukhu La Thandizo La Pa Foni (Offline Guides):" else "First Aid Action Guides:",
                fontWeight = FontWeight.Bold,
                fontSize = (16 * scale).sp,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(bottom = 12.dp)
            )
        }

        // List of First Aid Guide Cards
        if (guides.isEmpty()) {
            item {
                Surface(
                    color = MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = if (lang == Language.CHICHEWA) "Palibe zotsatira pa zomwe mwasaka." else "No matching guides found.",
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                            fontSize = (14 * scale).sp
                        )
                    }
                }
            }
        } else {
            items(guides) { guide ->
                GuideCardItem(
                    guide = guide,
                    lang = lang,
                    fontScale = scale,
                    onClick = { onSelectGuide(guide) }
                )
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun CategoryChip(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    fontScale: Float
) {
    Surface(
        shape = RoundedCornerShape(20.dp),
        color = if (isSelected) PrimaryTeal else Color(0xFFE2E8F0),
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .clickable { onClick() }
    ) {
        Text(
            text = title,
            color = if (isSelected) Color.White else Color(0xFF334155),
            fontSize = (12 * fontScale).sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
        )
    }
}

@Composable
fun GuideCardItem(
    guide: FirstAidGuide,
    lang: Language,
    fontScale: Float,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .clickable { onClick() }
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
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(LightTealContainer),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = guide.category.titleChichewa.take(1),
                            color = PrimaryTeal,
                            fontWeight = FontWeight.Bold,
                            fontSize = (18 * fontScale).sp
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = if (lang == Language.CHICHEWA) guide.titleChichewa else guide.titleEnglish,
                            fontWeight = FontWeight.Bold,
                            fontSize = (15 * fontScale).sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "${guide.steps.size} ${if (lang == Language.CHICHEWA) "Magawo a Thandizo" else "Steps"}",
                            fontSize = (11 * fontScale).sp,
                            color = PrimaryTeal,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }

                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = Color(0xFFF1F5F9)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Open",
                        tint = PrimaryTeal,
                        modifier = Modifier
                            .padding(8.dp)
                            .size(18.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = if (lang == Language.CHICHEWA) guide.summaryChichewa else guide.summaryEnglish,
                fontSize = (12 * fontScale).sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
                lineHeight = (18 * fontScale).sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            // First step preview banner
            guide.steps.firstOrNull()?.let { firstStep ->
                Surface(
                    color = Color(0xFFF8FAFC),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(22.dp)
                                .clip(CircleShape)
                                .background(EmergencyRed),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "1",
                                color = Color.White,
                                fontSize = (11 * fontScale).sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (lang == Language.CHICHEWA) firstStep.titleChichewa else firstStep.titleEnglish,
                            fontSize = (12 * fontScale).sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF1E293B)
                        )
                    }
                }
            }
        }
    }
}
