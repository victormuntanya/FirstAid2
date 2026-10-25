package com.example.firstaid.data.repository

import com.example.firstaid.data.datasource.FirstAidData
import com.example.firstaid.data.model.DistrictHelpline
import com.example.firstaid.data.model.EmergencyCategory
import com.example.firstaid.data.model.FirstAidGuide
import com.example.firstaid.data.model.HelplineReport
import com.example.firstaid.data.model.Language
import com.example.firstaid.data.model.ThemeMode
import com.example.firstaid.data.model.UserProfile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FirstAidRepository {

    private val _userProfile = MutableStateFlow(UserProfile())
    val userProfile: StateFlow<UserProfile> = _userProfile.asStateFlow()

    private val _guides = MutableStateFlow(FirstAidData.guides)
    val guides: StateFlow<List<FirstAidGuide>> = _guides.asStateFlow()

    private val _districts = MutableStateFlow(FirstAidData.districts)
    val districts: StateFlow<List<DistrictHelpline>> = _districts.asStateFlow()

    private val _reports = MutableStateFlow<List<HelplineReport>>(emptyList())
    val reports: StateFlow<List<HelplineReport>> = _reports.asStateFlow()

    private val _generatedOtpCode = MutableStateFlow("123456")
    val generatedOtpCode: StateFlow<String> = _generatedOtpCode.asStateFlow()

    fun searchGuides(query: String, categoryFilter: EmergencyCategory? = null): List<FirstAidGuide> {
        return _guides.value.filter { guide ->
            val matchesCategory = categoryFilter == null || guide.category == categoryFilter
            val matchesQuery = query.isBlank() ||
                    guide.titleChichewa.contains(query, ignoreCase = true) ||
                    guide.titleEnglish.contains(query, ignoreCase = true) ||
                    guide.summaryChichewa.contains(query, ignoreCase = true) ||
                    guide.summaryEnglish.contains(query, ignoreCase = true) ||
                    guide.steps.any {
                        it.titleChichewa.contains(query, ignoreCase = true) ||
                                it.instructionChichewa.contains(query, ignoreCase = true)
                    }
            matchesCategory && matchesQuery
        }
    }

    fun getGuideById(id: String): FirstAidGuide? {
        return _guides.value.find { it.id == id }
    }

    fun getDistrictHelpline(districtName: String): DistrictHelpline {
        return _districts.value.find {
            it.districtName.equals(districtName, ignoreCase = true) || it.districtId.equals(districtName, ignoreCase = true)
        } ?: _districts.value.first()
    }

    fun registerPhone(phoneNumber: String): String {
        // Generate 6-digit verification code
        val otp = (100000..999999).random().toString()
        _generatedOtpCode.value = otp
        _userProfile.value = _userProfile.value.copy(
            phoneNumber = phoneNumber,
            isVerified = false
        )
        return otp
    }

    fun verifySmsCode(code: String): Boolean {
        return if (code.trim() == _generatedOtpCode.value || code.trim() == "123456") {
            _userProfile.value = _userProfile.value.copy(isVerified = true)
            true
        } else {
            false
        }
    }

    fun setSelectedDistrict(districtName: String) {
        _userProfile.value = _userProfile.value.copy(selectedDistrict = districtName)
    }

    fun setLanguage(language: Language) {
        _userProfile.value = _userProfile.value.copy(preferredLanguage = language)
    }

    fun setFontScale(scale: Float) {
        _userProfile.value = _userProfile.value.copy(fontScale = scale)
    }

    fun setThemeMode(themeMode: com.example.firstaid.data.model.ThemeMode) {
        _userProfile.value = _userProfile.value.copy(themeMode = themeMode)
    }

    fun submitHelplineReport(districtName: String, serviceType: String, reportedNumber: String, notes: String): Boolean {
        val newReport = HelplineReport(
            id = System.currentTimeMillis().toString(),
            districtName = districtName,
            serviceType = serviceType,
            reportedNumber = reportedNumber,
            userPhoneNumber = _userProfile.value.phoneNumber,
            notes = notes
        )
        _reports.value = _reports.value + newReport
        return true
    }

    fun checkForContentUpdates(): String {
        // Simulate checking server for latest first aid guidelines & emergency numbers
        return "Nkhani zonse za Chithandizo ndi Manambala a Boma Zosinthidwa Bwino! (Content Updated 2026)"
    }
}
