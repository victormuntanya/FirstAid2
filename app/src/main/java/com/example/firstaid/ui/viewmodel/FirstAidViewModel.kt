package com.example.firstaid.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstaid.data.model.DistrictHelpline
import com.example.firstaid.data.model.EmergencyCategory
import com.example.firstaid.data.model.FirstAidGuide
import com.example.firstaid.data.model.Language
import com.example.firstaid.data.model.ThemeMode
import com.example.firstaid.data.model.UserProfile
import com.example.firstaid.data.repository.FirstAidRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

enum class AppTab {
    HOME,
    HELPLINES,
    SETTINGS
}

class FirstAidViewModel(
    private val repository: FirstAidRepository = FirstAidRepository()
) : ViewModel() {

    private val _selectedTab = MutableStateFlow(AppTab.HOME)
    val selectedTab: StateFlow<AppTab> = _selectedTab.asStateFlow()

    private val _userProfile = repository.userProfile
    val userProfile: StateFlow<UserProfile> = _userProfile

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _selectedCategory = MutableStateFlow<EmergencyCategory?>(null)
    val selectedCategory: StateFlow<EmergencyCategory?> = _selectedCategory.asStateFlow()

    private val _selectedGuide = MutableStateFlow<FirstAidGuide?>(null)
    val selectedGuide: StateFlow<FirstAidGuide?> = _selectedGuide.asStateFlow()

    private val _districts = repository.districts
    val districts: StateFlow<List<DistrictHelpline>> = _districts

    private val _filteredGuides = MutableStateFlow(repository.searchGuides(""))
    val filteredGuides: StateFlow<List<FirstAidGuide>> = _filteredGuides.asStateFlow()

    // Phone Registration Modal State
    private val _showAuthModal = MutableStateFlow(false)
    val showAuthModal: StateFlow<Boolean> = _showAuthModal.asStateFlow()

    private val _authPhoneInput = MutableStateFlow("")
    val authPhoneInput: StateFlow<String> = _authPhoneInput.asStateFlow()

    private val _authOtpInput = MutableStateFlow("")
    val authOtpInput: StateFlow<String> = _authOtpInput.asStateFlow()

    private val _otpSent = MutableStateFlow(false)
    val otpSent: StateFlow<Boolean> = _otpSent.asStateFlow()

    private val _authError = MutableStateFlow<String?>(null)
    val authError: StateFlow<String?> = _authError.asStateFlow()

    private val _authSuccessMessage = MutableStateFlow<String?>(null)
    val authSuccessMessage: StateFlow<String?> = _authSuccessMessage.asStateFlow()

    // Report Helpline Modal State
    private val _showReportModal = MutableStateFlow(false)
    val showReportModal: StateFlow<Boolean> = _showReportModal.asStateFlow()

    private val _reportServiceType = MutableStateFlow("Chipatala / Hospital")
    val reportServiceType: StateFlow<String> = _reportServiceType.asStateFlow()

    private val _reportNumberInput = MutableStateFlow("")
    val reportNumberInput: StateFlow<String> = _reportNumberInput.asStateFlow()

    private val _reportNotesInput = MutableStateFlow("")
    val reportNotesInput: StateFlow<String> = _reportNotesInput.asStateFlow()

    // System Toast/Banner Message
    private val _systemMessage = MutableStateFlow<String?>(null)
    val systemMessage: StateFlow<String?> = _systemMessage.asStateFlow()

    fun selectTab(tab: AppTab) {
        _selectedTab.value = tab
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
        _filteredGuides.value = repository.searchGuides(query, _selectedCategory.value)
    }

    fun selectCategory(category: EmergencyCategory?) {
        _selectedCategory.value = if (_selectedCategory.value == category) null else category
        _filteredGuides.value = repository.searchGuides(_searchQuery.value, _selectedCategory.value)
    }

    fun openGuideDetail(guide: FirstAidGuide) {
        _selectedGuide.value = guide
    }

    fun closeGuideDetail() {
        _selectedGuide.value = null
    }

    fun setSelectedDistrict(districtName: String) {
        repository.setSelectedDistrict(districtName)
        _systemMessage.value = "Boma lafufuzidwa: $districtName"
    }

    fun setLanguage(language: Language) {
        repository.setLanguage(language)
        val langName = if (language == Language.CHICHEWA) "Chichewa" else "English"
        _systemMessage.value = "Chiyankhulo chasinthidwa: $langName"
    }

    fun setFontScale(scale: Float) {
        repository.setFontScale(scale)
    }

    fun setThemeMode(themeMode: ThemeMode) {
        repository.setThemeMode(themeMode)
        val modeName = when (themeMode) {
            ThemeMode.LIGHT -> "Yoyera (Light)"
            ThemeMode.DARK -> "Yodada / Yakuda (Dark)"
            ThemeMode.SYSTEM -> "Za Foni (System Default)"
        }
        _systemMessage.value = "Maonekedwe asinthidwa: $modeName"
    }

    fun openAuthModal() {
        _showAuthModal.value = true
        _authPhoneInput.value = _userProfile.value.phoneNumber
        _authOtpInput.value = ""
        _otpSent.value = false
        _authError.value = null
    }

    fun closeAuthModal() {
        _showAuthModal.value = false
    }

    fun updateAuthPhoneInput(phone: String) {
        _authPhoneInput.value = phone
    }

    fun updateAuthOtpInput(otp: String) {
        _authOtpInput.value = otp
    }

    fun sendSmsCode() {
        val phone = _authPhoneInput.value.trim()
        if (phone.length < 8) {
            _authError.value = "Chonde lowetsani nambala ya foni yoyenera (e.g. +265 999 123 456)."
            return
        }
        val otpCode = repository.registerPhone(phone)
        _otpSent.value = true
        _authError.value = null
        _authSuccessMessage.value = "Khodi yachitsimikizo (SMS Code) yatumizidwa: $otpCode"
    }

    fun verifySmsCode() {
        val code = _authOtpInput.value.trim()
        if (code.isEmpty()) {
            _authError.value = "Chonde lowetsani khodi ya SMS."
            return
        }
        val isVerified = repository.verifySmsCode(code)
        if (isVerified) {
            _authError.value = null
            _showAuthModal.value = false
            _systemMessage.value = "Zikomo! Foni yanu yatsimikizidwa bwinobwino."
        } else {
            _authError.value = "Khodi siyilondola! Chonde yesani khodi 123456 kapena yomwe yatumizidwa."
        }
    }

    fun openReportModal() {
        _showReportModal.value = true
        _reportNumberInput.value = ""
        _reportNotesInput.value = ""
    }

    fun closeReportModal() {
        _showReportModal.value = false
    }

    fun updateReportServiceType(type: String) {
        _reportServiceType.value = type
    }

    fun updateReportNumberInput(num: String) {
        _reportNumberInput.value = num
    }

    fun updateReportNotesInput(notes: String) {
        _reportNotesInput.value = notes
    }

    fun submitHelplineReport() {
        val num = _reportNumberInput.value.trim()
        if (num.isEmpty()) {
            _systemMessage.value = "Chonde lowetsani nambala yomwe siyikugwira ntchito."
            return
        }
        val district = _userProfile.value.selectedDistrict
        repository.submitHelplineReport(
            districtName = district,
            serviceType = _reportServiceType.value,
            reportedNumber = num,
            notes = _reportNotesInput.value
        )
        _showReportModal.value = false
        _systemMessage.value = "Zikomo! Lipoti lanu pa manambala lafika kwa adokotala."
    }

    fun checkContentUpdates() {
        viewModelScope.launch {
            val msg = repository.checkForContentUpdates()
            _systemMessage.value = msg
        }
    }

    fun dismissSystemMessage() {
        _systemMessage.value = null
    }
}
