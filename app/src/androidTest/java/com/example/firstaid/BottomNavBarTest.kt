package com.example.firstaid

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.firstaid.data.model.Language
import com.example.firstaid.ui.components.BottomNavBar
import com.example.firstaid.ui.viewmodel.AppTab
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BottomNavBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testBottomNavBarEnglishLabelsAndSelection() {
        var selectedTab = AppTab.HOME

        composeTestRule.setContent {
            BottomNavBar(
                selectedTab = selectedTab,
                language = Language.ENGLISH,
                fontScale = 1.0f,
                onTabSelected = { selectedTab = it }
            )
        }

        // Verify items are displayed in English
        composeTestRule.onNodeWithText("Guides").assertExists()
        composeTestRule.onNodeWithText("Helplines").assertExists()
        composeTestRule.onNodeWithText("Settings").assertExists()

        // Click Helplines
        composeTestRule.onNodeWithText("Helplines").performClick()
        assert(selectedTab == AppTab.HELPLINES)
    }

    @Test
    fun testBottomNavBarChichewaLabels() {
        composeTestRule.setContent {
            BottomNavBar(
                selectedTab = AppTab.HOME,
                language = Language.CHICHEWA,
                fontScale = 1.0f,
                onTabSelected = {}
            )
        }

        // Verify items are displayed in Chichewa
        composeTestRule.onNodeWithText("Zothandiza").assertExists()
        composeTestRule.onNodeWithText("Manambala").assertExists()
        composeTestRule.onNodeWithText("Zokonda").assertExists()
    }
}
