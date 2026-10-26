package com.example.firstaid

import com.example.firstaid.data.model.EmergencyCategory
import com.example.firstaid.data.model.Language
import com.example.firstaid.data.model.ThemeMode
import com.example.firstaid.ui.viewmodel.AppTab
import com.example.firstaid.ui.viewmodel.FirstAidViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FirstAidViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var viewModel: FirstAidViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        viewModel = FirstAidViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testInitialState() {
        assertEquals(AppTab.HOME, viewModel.selectedTab.value)
        assertEquals("", viewModel.searchQuery.value)
        assertEquals(null, viewModel.selectedCategory.value)
        assertFalse(viewModel.userProfile.value.isVerified)
    }

    @Test
    fun testTabSelection() {
        viewModel.selectTab(AppTab.HELPLINES)
        assertEquals(AppTab.HELPLINES, viewModel.selectedTab.value)

        viewModel.selectTab(AppTab.SETTINGS)
        assertEquals(AppTab.SETTINGS, viewModel.selectedTab.value)

        viewModel.selectTab(AppTab.HOME)
        assertEquals(AppTab.HOME, viewModel.selectedTab.value)
    }

    @Test
    fun testSearchQueryFiltering() {
        viewModel.updateSearchQuery("bleeding")
        val filtered = viewModel.filteredGuides.value
        assertTrue(filtered.any { it.id == "bleeding" })
    }

    @Test
    fun testCategorySelection() {
        viewModel.selectCategory(EmergencyCategory.BURNS)
        assertEquals(EmergencyCategory.BURNS, viewModel.selectedCategory.value)
        val filtered = viewModel.filteredGuides.value
        assertTrue(filtered.all { it.category == EmergencyCategory.BURNS })

        // Toggle off
        viewModel.selectCategory(EmergencyCategory.BURNS)
        assertEquals(null, viewModel.selectedCategory.value)
    }

    @Test
    fun testGuideDetailSelection() {
        val guide = viewModel.filteredGuides.value.first()
        viewModel.openGuideDetail(guide)
        assertEquals(guide, viewModel.selectedGuide.value)

        viewModel.closeGuideDetail()
        assertEquals(null, viewModel.selectedGuide.value)
    }

    @Test
    fun testProfileSettingsUpdates() {
        viewModel.setSelectedDistrict("Blantyre")
        assertEquals("Blantyre", viewModel.userProfile.value.selectedDistrict)

        viewModel.setLanguage(Language.CHICHEWA)
        assertEquals(Language.CHICHEWA, viewModel.userProfile.value.preferredLanguage)

        viewModel.setFontScale(1.5f)
        assertEquals(1.5f, viewModel.userProfile.value.fontScale, 0.01f)

        viewModel.setThemeMode(ThemeMode.DARK)
        assertEquals(ThemeMode.DARK, viewModel.userProfile.value.themeMode)
    }

    @Test
    fun testPhoneAuthModalFlow() {
        viewModel.openAuthModal()
        assertTrue(viewModel.showAuthModal.value)

        viewModel.updateAuthPhoneInput("+265 999 000 111")
        assertEquals("+265 999 000 111", viewModel.authPhoneInput.value)

        viewModel.sendSmsCode()
        assertTrue(viewModel.otpSent.value)

        viewModel.updateAuthOtpInput("123456")
        assertEquals("123456", viewModel.authOtpInput.value)

        viewModel.verifySmsCode()
        assertTrue(viewModel.userProfile.value.isVerified)
        assertFalse(viewModel.showAuthModal.value)
    }

    @Test
    fun testHelplineReportModalFlow() {
        viewModel.openReportModal()
        assertTrue(viewModel.showReportModal.value)

        viewModel.updateReportServiceType("Ambulance")
        assertEquals("Ambulance", viewModel.reportServiceType.value)

        viewModel.updateReportNumberInput("+265 1 876 543")
        assertEquals("+265 1 876 543", viewModel.reportNumberInput.value)

        viewModel.updateReportNotesInput("Test notes for reporting helpline")
        assertEquals("Test notes for reporting helpline", viewModel.reportNotesInput.value)

        viewModel.submitHelplineReport()
        assertFalse(viewModel.showReportModal.value)
        assertNotNull(viewModel.systemMessage.value)
    }

    @Test
    fun testCheckContentUpdates() = runTest {
        viewModel.checkContentUpdates()
        testDispatcher.scheduler.advanceUntilIdle()
        assertNotNull(viewModel.systemMessage.value)
    }
}
