package com.example.firstaid.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.firstaid.data.model.Language
import com.example.firstaid.ui.theme.DarkSlateHeader
import com.example.firstaid.ui.theme.PrimaryTeal
import com.example.firstaid.ui.viewmodel.AppTab

@Composable
fun BottomNavBar(
    selectedTab: AppTab,
    language: Language,
    fontScale: Float,
    onTabSelected: (AppTab) -> Unit
) {
    NavigationBar(
        // Translucent dark slate container so scrolled list items appear faint in the background
        containerColor = DarkSlateHeader.copy(alpha = 0.75f),
        contentColor = Color.White
    ) {
        NavigationBarItem(
            selected = selectedTab == AppTab.HOME,
            onClick = { onTabSelected(AppTab.HOME) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"
                )
            },
            label = {
                Text(
                    text = if (language == Language.CHICHEWA) "Zothandiza" else "Guides",
                    fontSize = (11 * fontScale).sp,
                    fontWeight = if (selectedTab == AppTab.HOME) FontWeight.Bold else FontWeight.Normal
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                indicatorColor = PrimaryTeal,
                unselectedIconColor = Color(0xFFB0BEC5),
                unselectedTextColor = Color(0xFFB0BEC5)
            )
        )

        NavigationBarItem(
            selected = selectedTab == AppTab.HELPLINES,
            onClick = { onTabSelected(AppTab.HELPLINES) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "Helplines"
                )
            },
            label = {
                Text(
                    text = if (language == Language.CHICHEWA) "Manambala" else "Helplines",
                    fontSize = (11 * fontScale).sp,
                    fontWeight = if (selectedTab == AppTab.HELPLINES) FontWeight.Bold else FontWeight.Normal
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                indicatorColor = PrimaryTeal,
                unselectedIconColor = Color(0xFFB0BEC5),
                unselectedTextColor = Color(0xFFB0BEC5)
            )
        )

        NavigationBarItem(
            selected = selectedTab == AppTab.SETTINGS,
            onClick = { onTabSelected(AppTab.SETTINGS) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings"
                )
            },
            label = {
                Text(
                    text = if (language == Language.CHICHEWA) "Zokonda" else "Settings",
                    fontSize = (11 * fontScale).sp,
                    fontWeight = if (selectedTab == AppTab.SETTINGS) FontWeight.Bold else FontWeight.Normal
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                indicatorColor = PrimaryTeal,
                unselectedIconColor = Color(0xFFB0BEC5),
                unselectedTextColor = Color(0xFFB0BEC5)
            )
        )
    }
}
