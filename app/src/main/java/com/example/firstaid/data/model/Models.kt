package com.example.firstaid.data.model

enum class Language {
    CHICHEWA,
    ENGLISH
}

enum class ThemeMode {
    SYSTEM,
    LIGHT,
    DARK
}

enum class EmergencyCategory(val id: String, val titleChichewa: String, val titleEnglish: String) {
    BLEEDING("bleeding", "Mukutuluka Magazi", "Bleeding"),
    BURNS("burns", "Kupsa Ndi Moto / Madzi", "Burns & Scalds"),
    FRACTURES("fractures", "Kuthyoka Fupa", "Fractures & Sprains"),
    CHOKING("choking", "Kutsamwa", "Choking"),
    ACCIDENTS("accidents", "Zogunda Galimoto", "Road Accidents"),
    DROWNING("drowning", "Kumira M'madzi", "Drowning"),
    SNAKE_BITES("snake_bites", "Kulumwa Ndi Njoka", "Snake Bites"),
    FAINTING("fainting", "Kukomoka", "Fainting & Unconsciousness"),
    POISONING("poisoning", "Apoizoni / Mankhwala", "Poisoning"),
    CPR_HEART_ATTACK("cpr_heart", "Kuyima Mtima / CPR", "CPR & Heart Attack"),
    STROKE("stroke", "Kufa Ziwalo (Stroke)", "Stroke & Paralysis"),
    SEIZURES("seizures", "Kukomoka kwa Khunyu", "Seizures & Epilepsy"),
    ALLERGIES("allergies", "Kusamva Mankhwala (Allergy)", "Severe Allergies & Shock"),
    ANIMAL_BITES("animal_bites", "Kulumwa Ndi Galu / Chiwanda", "Dog & Animal Bites (Rabies)"),
    HEAT_STROKE("heat_stroke", "Kutenthedwa Kwambiri", "Heat Stroke"),
    ASTHMA("asthma", "Kukanika Kupuma (Asitima)", "Asthma Attack"),
    DIABETES("diabetes", "Shuga Wokwera / Wogwa", "Diabetic Emergency"),
    EYE_INJURIES("eye_injuries", "Kuvulala M'maso", "Eye Injuries"),
    HEAD_INJURY("head_injury", "Kuvulala Mutu / Khosi", "Head & Spine Injury"),
    EMERGENCY_BIRTH("emergency_birth", "Kubeleka Mwadzidzidzi", "Emergency Labor & Birth")
}

data class StepItem(
    val stepNumber: Int,
    val titleChichewa: String,
    val titleEnglish: String,
    val instructionChichewa: String,
    val instructionEnglish: String,
    val warningNoteChichewa: String? = null,
    val warningNoteEnglish: String? = null,
    val iconName: String = "info"
)

data class FirstAidGuide(
    val id: String,
    val category: EmergencyCategory,
    val titleChichewa: String,
    val titleEnglish: String,
    val summaryChichewa: String,
    val summaryEnglish: String,
    val steps: List<StepItem>,
    val dosChichewa: List<String>,
    val dosEnglish: List<String>,
    val dontsChichewa: List<String>,
    val dontsEnglish: List<String>,
    val emergencyTipChichewa: String,
    val emergencyTipEnglish: String
)

data class DistrictHelpline(
    val districtId: String,
    val districtName: String,
    val region: String,
    val hospitalName: String,
    val hospitalNumber: String,
    val policeName: String,
    val policeNumber: String,
    val ambulanceNumber: String,
    val redCrossNumber: String = "118",
    val verifiedDate: String = "2026-03"
)

data class HelplineReport(
    val id: String,
    val districtName: String,
    val serviceType: String,
    val reportedNumber: String,
    val userPhoneNumber: String,
    val notes: String,
    val timestamp: Long = System.currentTimeMillis()
)

data class UserProfile(
    val phoneNumber: String = "",
    val isVerified: Boolean = false,
    val selectedDistrict: String = "Lilongwe",
    val preferredLanguage: Language = Language.CHICHEWA,
    val fontScale: Float = 1.0f,
    val themeMode: ThemeMode = ThemeMode.SYSTEM
)
