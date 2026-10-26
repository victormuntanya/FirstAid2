package com.example.firstaid

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.firstaid.data.datasource.FirstAidData
import com.example.firstaid.data.model.UserProfile
import com.example.firstaid.ui.components.AppHeaderBar
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppHeaderBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testAppHeaderBarRenderingAndClicks() {
        val profile = UserProfile(selectedDistrict = "Lilongwe", isVerified = false)
        var authModalOpened = false

        composeTestRule.setContent {
            AppHeaderBar(
                userProfile = profile,
                districts = FirstAidData.districts,
                onSelectDistrict = {},
                onOpenAuthModal = { authModalOpened = true }
            )
        }

        // Verify district badge text
        composeTestRule.onNodeWithText("Boma: Lilongwe ▼").assertExists()

        // Verify auth button text
        composeTestRule.onNodeWithText("Lembetsani Foni").assertExists()

        // Click auth button
        composeTestRule.onNodeWithText("Lembetsani Foni").performClick()
        assert(authModalOpened)
    }
}
