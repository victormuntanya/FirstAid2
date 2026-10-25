package com.example.firstaid.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstaid.data.model.DistrictHelpline
import com.example.firstaid.data.model.Language
import com.example.firstaid.data.model.UserProfile
import com.example.firstaid.ui.theme.DarkSlateHeader

@Composable
fun AppHeaderBar(
    userProfile: UserProfile,
    districts: List<DistrictHelpline>,
    onSelectDistrict: (String) -> Unit,
    onOpenAuthModal: () -> Unit
) {
    var districtMenuExpanded by remember { mutableStateOf(false) }

    Surface(
        color = DarkSlateHeader,
        contentColor = Color.White,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(horizontal = 16.dp, vertical = 14.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Bandage Icon with "First Aid MA" title
                BandageHeaderTitle(
                    subtitleText = if (userProfile.preferredLanguage == Language.CHICHEWA) "Chichewa First Aid" else "Malawi First Aid"
                )

                // Note: Top right action icons removed as requested. (Settings tab now contains language & font scale settings).
            }

            Spacer(modifier = Modifier.padding(top = 10.dp))

            // Sub-row: District Location Badge & Phone Auth Badge
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // District Chip Dropdown
                Box {
                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = Color(0xFF1E3A40),
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .clickable { districtMenuExpanded = true }
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.LocationOn,
                                contentDescription = "District",
                                tint = Color(0xFF80CBC4),
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "Boma: ${userProfile.selectedDistrict} ▼",
                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }

                    DropdownMenu(
                        expanded = districtMenuExpanded,
                        onDismissRequest = { districtMenuExpanded = false }
                    ) {
                        districts.forEach { dist ->
                            DropdownMenuItem(
                                text = { Text("${dist.districtName} (${dist.region})") },
                                onClick = {
                                    onSelectDistrict(dist.districtName)
                                    districtMenuExpanded = false
                                }
                            )
                        }
                    }
                }

                // Phone Verification Chip
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = if (userProfile.isVerified) Color(0xFF1B5E20) else Color(0xFF00695C),
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .clickable { onOpenAuthModal() }
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = if (userProfile.isVerified) Icons.Default.CheckCircle else Icons.Default.Phone,
                            contentDescription = "Auth Status",
                            tint = Color.White,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = if (userProfile.isVerified) "Yatsimikizidwa ✓" else "Lembetsani Foni",
                            color = Color.White,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    }
}
