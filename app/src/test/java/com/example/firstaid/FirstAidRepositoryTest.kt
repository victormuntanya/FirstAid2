package com.example.firstaid

import com.example.firstaid.data.model.EmergencyCategory
import com.example.firstaid.data.model.Language
import com.example.firstaid.data.model.ThemeMode
import com.example.firstaid.data.repository.FirstAidRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class FirstAidRepositoryTest {

    private lateinit var repository: FirstAidRepository

    @Before
    fun setUp() {
        repository = FirstAidRepository()
    }

    @Test
    fun testOfflineGuidesAvailable() {
        val guides = repository.guides.value
        assertTrue("At least 9 emergency first aid guides should be pre-loaded offline", guides.size >= 9)
    }

    @Test
    fun testSearchBleedingGuide() {
        val results = repository.searchGuides("magazi")
        assertTrue("Searching for 'magazi' should return the bleeding guide", results.any { it.id == "bleeding" })
    }

    @Test
    fun testCategoryFilter() {
        val results = repository.searchGuides("", EmergencyCategory.SNAKE_BITES)
        assertEquals(1, results.size)
        assertEquals("snake_bites", results.first().id)
    }

    @Test
    fun testPhoneRegistrationAndVerificationWithoutEmail() {
        val phoneNumber = "+265 999 123 456"
        val otpCode = repository.registerPhone(phoneNumber)

        assertFalse(repository.userProfile.value.isVerified)
        assertEquals(phoneNumber, repository.userProfile.value.phoneNumber)
        assertNotNull(otpCode)

        val verified = repository.verifySmsCode(otpCode)
        assertTrue(verified)
        assertTrue(repository.userProfile.value.isVerified)
    }

    @Test
    fun testDistrictHelplines() {
        val lilongweHelpline = repository.getDistrictHelpline("Lilongwe")
        assertEquals("Lilongwe", lilongweHelpline.districtName)
        assertEquals("Kamuzu Central Hospital (KCH)", lilongweHelpline.hospitalName)

        val blantyreHelpline = repository.getDistrictHelpline("Blantyre")
        assertEquals("Blantyre", blantyreHelpline.districtName)
        assertEquals("Queen Elizabeth Central Hospital (QECH)", blantyreHelpline.hospitalName)
    }

    @Test
    fun testThemeModeSetting() {
        repository.setThemeMode(ThemeMode.DARK)
        assertEquals(ThemeMode.DARK, repository.userProfile.value.themeMode)

        repository.setThemeMode(ThemeMode.LIGHT)
        assertEquals(ThemeMode.LIGHT, repository.userProfile.value.themeMode)
    }

    @Test
    fun testLanguageAndFontScalingSettings() {
        repository.setLanguage(Language.CHICHEWA)
        assertEquals(Language.CHICHEWA, repository.userProfile.value.preferredLanguage)

        repository.setFontScale(1.25f)
        assertEquals(1.25f, repository.userProfile.value.fontScale, 0.01f)
    }
}
