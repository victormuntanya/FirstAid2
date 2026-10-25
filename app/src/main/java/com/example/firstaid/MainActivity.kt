package com.example.firstaid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.firstaid.ui.components.AppHeaderBar
import com.example.firstaid.ui.components.BottomNavBar
import com.example.firstaid.ui.components.GuideDetailModal
import com.example.firstaid.ui.components.PhoneAuthModal
import com.example.firstaid.ui.components.ReportHelplineModal
import com.example.firstaid.ui.screens.HelplinesScreen
import com.example.firstaid.ui.screens.HomeScreen
import com.example.firstaid.ui.screens.SettingsScreen
import com.example.firstaid.ui.theme.FirstAidTheme
import com.example.firstaid.ui.viewmodel.AppTab
import com.example.firstaid.ui.viewmodel.FirstAidViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstAidMainAppHost()
        }
    }
}

@Composable
fun FirstAidMainAppHost(
    viewModel: FirstAidViewModel = viewModel()
) {
    val userProfile by viewModel.userProfile.collectAsState()

    FirstAidTheme(themeMode = userProfile.themeMode) {
        FirstAidMainApp(viewModel = viewModel)
    }
}

@Composable
fun FirstAidMainApp(
    viewModel: FirstAidViewModel
) {
    val selectedTab by viewModel.selectedTab.collectAsState()
    val userProfile by viewModel.userProfile.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val selectedCategory by viewModel.selectedCategory.collectAsState()
    val selectedGuide by viewModel.selectedGuide.collectAsState()
    val districts by viewModel.districts.collectAsState()
    val filteredGuides by viewModel.filteredGuides.collectAsState()

    val showAuthModal by viewModel.showAuthModal.collectAsState()
    val authPhoneInput by viewModel.authPhoneInput.collectAsState()
    val authOtpInput by viewModel.authOtpInput.collectAsState()
    val otpSent by viewModel.otpSent.collectAsState()
    val authError by viewModel.authError.collectAsState()
    val authSuccessMessage by viewModel.authSuccessMessage.collectAsState()

    val showReportModal by viewModel.showReportModal.collectAsState()
    val reportServiceType by viewModel.reportServiceType.collectAsState()
    val reportNumberInput by viewModel.reportNumberInput.collectAsState()
    val reportNotesInput by viewModel.reportNotesInput.collectAsState()

    val systemMessage by viewModel.systemMessage.collectAsState()

    val selectedDistrictHelpline = districts.find {
        it.districtName.equals(userProfile.selectedDistrict, ignoreCase = true)
    } ?: districts.first()

    Scaffold(
        topBar = {
            AppHeaderBar(
                userProfile = userProfile,
                districts = districts,
                onSelectDistrict = { viewModel.setSelectedDistrict(it) },
                onOpenAuthModal = { viewModel.openAuthModal() }
            )
        },
        bottomBar = {
            BottomNavBar(
                selectedTab = selectedTab,
                language = userProfile.preferredLanguage,
                fontScale = userProfile.fontScale,
                onTabSelected = { viewModel.selectTab(it) }
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                // System Notification Banner with AnimatedVisibility
                AnimatedVisibility(
                    visible = !systemMessage.isNullOrBlank(),
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    systemMessage?.let { msg ->
                        Surface(
                            color = Color(0xFF00796B),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(horizontal = 16.dp, vertical = 10.dp)
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Info,
                                    contentDescription = "System Info",
                                    tint = Color.White,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = msg,
                                    color = Color.White,
                                    fontSize = (12 * userProfile.fontScale).sp,
                                    fontWeight = FontWeight.Medium,
                                    modifier = Modifier.weight(1f)
                                )
                                IconButton(
                                    onClick = { viewModel.dismissSystemMessage() },
                                    modifier = Modifier.size(24.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "Dismiss",
                                        tint = Color.White
                                    )
                                }
                            }
                        }
                    }
                }

                // Smooth Professional Animated Tab Transition
                AnimatedContent(
                    targetState = selectedTab,
                    transitionSpec = {
                        if (targetState.ordinal > initialState.ordinal) {
                            (slideInHorizontally { width -> width } + fadeIn()).togetherWith(
                                slideOutHorizontally { width -> -width } + fadeOut())
                        } else {
                            (slideInHorizontally { width -> -width } + fadeIn()).togetherWith(
                                slideOutHorizontally { width -> width } + fadeOut())
                        }
                    },
                    label = "TabScreenTransition",
                    modifier = Modifier.fillMaxSize()
                ) { targetTab ->
                    when (targetTab) {
                        AppTab.HOME -> {
                            HomeScreen(
                                userProfile = userProfile,
                                searchQuery = searchQuery,
                                selectedCategory = selectedCategory,
                                guides = filteredGuides,
                                onSearchQueryChange = { viewModel.updateSearchQuery(it) },
                                onSelectCategory = { viewModel.selectCategory(it) },
                                onSelectGuide = { viewModel.openGuideDetail(it) },
                                onOpenAuthModal = { viewModel.openAuthModal() }
                            )
                        }

                        AppTab.HELPLINES -> {
                            HelplinesScreen(
                                userProfile = userProfile,
                                districts = districts,
                                onSelectDistrict = { viewModel.setSelectedDistrict(it) },
                                onOpenReportModal = { viewModel.openReportModal() },
                                onCheckContentUpdates = { viewModel.checkContentUpdates() }
                            )
                        }

                        AppTab.SETTINGS -> {
                            SettingsScreen(
                                userProfile = userProfile,
                                districts = districts,
                                onSelectThemeMode = { viewModel.setThemeMode(it) },
                                onSelectLanguage = { viewModel.setLanguage(it) },
                                onSelectFontScale = { viewModel.setFontScale(it) },
                                onSelectDistrict = { viewModel.setSelectedDistrict(it) },
                                onOpenAuthModal = { viewModel.openAuthModal() }
                            )
                        }
                    }
                }
            }

            // Modal Overlays

            // 1. Phone Sign-Up Modal (FR1 & FR2)
            if (showAuthModal) {
                PhoneAuthModal(
                    userProfile = userProfile,
                    authPhoneInput = authPhoneInput,
                    authOtpInput = authOtpInput,
                    otpSent = otpSent,
                    authError = authError,
                    authSuccessMessage = authSuccessMessage,
                    onPhoneInputChange = { viewModel.updateAuthPhoneInput(it) },
                    onOtpInputChange = { viewModel.updateAuthOtpInput(it) },
                    onSendSmsCode = { viewModel.sendSmsCode() },
                    onVerifySmsCode = { viewModel.verifySmsCode() },
                    onDismiss = { viewModel.closeAuthModal() }
                )
            }

            // 2. Report Outdated Helpline Modal (FR11)
            if (showReportModal) {
                ReportHelplineModal(
                    selectedDistrict = userProfile.selectedDistrict,
                    reportServiceType = reportServiceType,
                    reportNumberInput = reportNumberInput,
                    reportNotesInput = reportNotesInput,
                    userLanguage = userProfile.preferredLanguage,
                    onServiceTypeChange = { viewModel.updateReportServiceType(it) },
                    onNumberInputChange = { viewModel.updateReportNumberInput(it) },
                    onNotesInputChange = { viewModel.updateReportNotesInput(it) },
                    onSubmitReport = { viewModel.submitHelplineReport() },
                    onDismiss = { viewModel.closeReportModal() }
                )
            }

            // 3. Full Guide Detail Modal
            selectedGuide?.let { guide ->
                GuideDetailModal(
                    guide = guide,
                    userLanguage = userProfile.preferredLanguage,
                    fontScale = userProfile.fontScale,
                    ambulanceNumber = selectedDistrictHelpline.ambulanceNumber,
                    onDismiss = { viewModel.closeGuideDetail() }
                )
            }
        }
    }
}
