package com.example.firstaid.ui.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Report
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.firstaid.data.model.FirstAidGuide
import com.example.firstaid.data.model.Language
import com.example.firstaid.data.model.UserProfile
import com.example.firstaid.ui.theme.CallGreen
import com.example.firstaid.ui.theme.DarkSlateHeader
import com.example.firstaid.ui.theme.EmergencyRed
import com.example.firstaid.ui.theme.PrimaryTeal

@Composable
fun PhoneAuthModal(
    userProfile: UserProfile,
    authPhoneInput: String,
    authOtpInput: String,
    otpSent: Boolean,
    authError: String?,
    authSuccessMessage: String?,
    onPhoneInputChange: (String) -> Unit,
    onOtpInputChange: (String) -> Unit,
    onSendSmsCode: () -> Unit,
    onVerifySmsCode: () -> Unit,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(24.dp),
            color = Color.White,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Phone,
                            contentDescription = "Phone",
                            tint = PrimaryTeal,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (userProfile.preferredLanguage == Language.CHICHEWA) "Kulembetsa Foni" else "Phone Sign-Up",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                    IconButton(onClick = onDismiss) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = if (userProfile.preferredLanguage == Language.CHICHEWA)
                        "Malinga ndi lamulo la First Aid MA, simusowa Email address. Lowetsani nambala ya foni yanu kuti mupindule ndi zinthu zonse."
                    else
                        "No email address required. Simply enter your phone number to complete offline registration.",
                    fontSize = 13.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = authPhoneInput,
                    onValueChange = onPhoneInputChange,
                    label = { Text(if (userProfile.preferredLanguage == Language.CHICHEWA) "Nambala ya Foni (e.g. 0999123456)" else "Phone Number") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                if (!otpSent) {
                    Button(
                        onClick = onSendSmsCode,
                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryTeal),
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Send, contentDescription = "SMS Code")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(if (userProfile.preferredLanguage == Language.CHICHEWA) "Tumizani SMS Code" else "Send SMS Verification Code")
                    }
                } else {
                    OutlinedTextField(
                        value = authOtpInput,
                        onValueChange = onOtpInputChange,
                        label = { Text(if (userProfile.preferredLanguage == Language.CHICHEWA) "Khodi ya SMS (e.g. 123456)" else "SMS Code") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = onVerifySmsCode,
                        colors = ButtonDefaults.buttonColors(containerColor = CallGreen),
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(imageVector = Icons.Default.CheckCircle, contentDescription = "Verify")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(if (userProfile.preferredLanguage == Language.CHICHEWA) "Tsimikizani Foni" else "Verify Phone Number")
                    }
                }

                if (!authSuccessMessage.isNullOrBlank()) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Surface(
                        color = Color(0xFFE8F5E9),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = authSuccessMessage,
                            color = Color(0xFF2E7D32),
                            fontSize = 12.sp,
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                }

                if (!authError.isNullOrBlank()) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = authError,
                        color = EmergencyRed,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportHelplineModal(
    selectedDistrict: String,
    reportServiceType: String,
    reportNumberInput: String,
    reportNotesInput: String,
    userLanguage: Language,
    onServiceTypeChange: (String) -> Unit,
    onNumberInputChange: (String) -> Unit,
    onNotesInputChange: (String) -> Unit,
    onSubmitReport: () -> Unit,
    onDismiss: () -> Unit
) {
    var expandedServiceType by remember { mutableStateOf(false) }
    val serviceTypes = listOf(
        "Chipatala / Hospital",
        "Apolisi / Police Station",
        "Ambulansi / Ambulance",
        "Red Cross Malawi"
    )

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(24.dp),
            color = Color.White,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Report,
                            contentDescription = "Report",
                            tint = EmergencyRed,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (userLanguage == Language.CHICHEWA) "Ripoti Nambala Yosagwira" else "Report Outdated Number",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }
                    IconButton(onClick = onDismiss) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = if (userLanguage == Language.CHICHEWA)
                        "Malinga ndi FR11, mutha kupereka lipoti la nambala yapadongosolo pa Boma la $selectedDistrict ngati siyikugwira ntchito."
                    else
                        "Pursuant to FR11, report incorrect or unreachable helpline numbers for $selectedDistrict.",
                    fontSize = 12.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(14.dp))

                ExposedDropdownMenuBox(
                    expanded = expandedServiceType,
                    onExpandedChange = { expandedServiceType = !expandedServiceType }
                ) {
                    OutlinedTextField(
                        value = reportServiceType,
                        onValueChange = {},
                        readOnly = true,
                        label = { Text(if (userLanguage == Language.CHICHEWA) "Mtundu wa Thandizo" else "Service Type") },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedServiceType) },
                        modifier = Modifier
                            .menuAnchor()
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    )
                    ExposedDropdownMenu(
                        expanded = expandedServiceType,
                        onDismissRequest = { expandedServiceType = false }
                    ) {
                        serviceTypes.forEach { st ->
                            DropdownMenuItem(
                                text = { Text(st) },
                                onClick = {
                                    onServiceTypeChange(st)
                                    expandedServiceType = false
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = reportNumberInput,
                    onValueChange = onNumberInputChange,
                    label = { Text(if (userLanguage == Language.CHICHEWA) "Nambala Yolakwika / Yosagwira" else "Incorrect/Outdated Number") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = reportNotesInput,
                    onValueChange = onNotesInputChange,
                    label = { Text(if (userLanguage == Language.CHICHEWA) "Zina Zowonjezera (Optional)" else "Additional Notes") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onDismiss) {
                        Text(if (userLanguage == Language.CHICHEWA) "Ayi / Cancel" else "Cancel")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = onSubmitReport,
                        colors = ButtonDefaults.buttonColors(containerColor = EmergencyRed),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(if (userLanguage == Language.CHICHEWA) "Tumizani Lipoti" else "Submit Report")
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuideDetailModal(
    guide: FirstAidGuide,
    userLanguage: Language,
    fontScale: Float,
    ambulanceNumber: String,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (userLanguage == Language.CHICHEWA) guide.titleChichewa else guide.titleEnglish,
                    fontWeight = FontWeight.Bold,
                    fontSize = (20 * fontScale).sp,
                    color = DarkSlateHeader,
                    modifier = Modifier.weight(1f)
                )
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = Color(0xFFE0F2F1)
                ) {
                    Text(
                        text = if (userLanguage == Language.CHICHEWA) guide.category.titleChichewa else guide.category.titleEnglish,
                        color = PrimaryTeal,
                        fontSize = (11 * fontScale).sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = if (userLanguage == Language.CHICHEWA) guide.summaryChichewa else guide.summaryEnglish,
                fontSize = (14 * fontScale).sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Emergency Call Shortcut Button
            Button(
                onClick = { triggerPhoneCall(context, ambulanceNumber) },
                colors = ButtonDefaults.buttonColors(containerColor = CallGreen),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
            ) {
                Icon(imageVector = Icons.Default.Call, contentDescription = "Call Ambulance")
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = if (userLanguage == Language.CHICHEWA) "Imbanirani Ambulansi ($ambulanceNumber)" else "Call Ambulance ($ambulanceNumber)",
                    fontSize = (14 * fontScale).sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Step-by-step guidance list
            Text(
                text = if (userLanguage == Language.CHICHEWA) "Magawo a Thandizo (Step-by-Step Guidance):" else "Step-by-Step Action Plan:",
                fontWeight = FontWeight.Bold,
                fontSize = (16 * fontScale).sp,
                color = PrimaryTeal
            )

            Spacer(modifier = Modifier.height(12.dp))

            guide.steps.forEach { step ->
                Card(
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF8FAFC)),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                        .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(16.dp))
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(CircleShape)
                                    .background(PrimaryTeal),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = step.stepNumber.toString(),
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = (14 * fontScale).sp
                                )
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = if (userLanguage == Language.CHICHEWA) step.titleChichewa else step.titleEnglish,
                                fontWeight = FontWeight.Bold,
                                fontSize = (15 * fontScale).sp,
                                color = DarkSlateHeader
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = if (userLanguage == Language.CHICHEWA) step.instructionChichewa else step.instructionEnglish,
                            fontSize = (13 * fontScale).sp,
                            color = Color(0xFF334155),
                            lineHeight = (19 * fontScale).sp
                        )

                        if (!step.warningNoteChichewa.isNullOrBlank()) {
                            Spacer(modifier = Modifier.height(8.dp))
                            Surface(
                                color = Color(0xFFFFEBEE),
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier.padding(8.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Warning,
                                        contentDescription = "Warning",
                                        tint = EmergencyRed,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = if (userLanguage == Language.CHICHEWA) step.warningNoteChichewa else (step.warningNoteEnglish ?: ""),
                                        color = EmergencyRed,
                                        fontSize = (12 * fontScale).sp,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Do's and Don'ts Card
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F8E9)),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = if (userLanguage == Language.CHICHEWA) "Zoyenera Kuchita (DO's):" else "DO'S:",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2E7D32),
                        fontSize = (14 * fontScale).sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    val dosList = if (userLanguage == Language.CHICHEWA) guide.dosChichewa else guide.dosEnglish
                    dosList.forEach { item ->
                        Text(
                            text = "✓ $item",
                            fontSize = (12 * fontScale).sp,
                            color = Color(0xFF1B5E20),
                            modifier = Modifier.padding(vertical = 2.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = if (userLanguage == Language.CHICHEWA) "Zosayenera Kuchita Kabisa (DON'TS):" else "DON'TS:",
                        fontWeight = FontWeight.Bold,
                        color = EmergencyRed,
                        fontSize = (14 * fontScale).sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    val dontsList = if (userLanguage == Language.CHICHEWA) guide.dontsChichewa else guide.dontsEnglish
                    dontsList.forEach { item ->
                        Text(
                            text = "✗ $item",
                            fontSize = (12 * fontScale).sp,
                            color = Color(0xFFB71C1C),
                            modifier = Modifier.padding(vertical = 2.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Emergency Tip Banner
            Surface(
                color = Color(0xFFFFF8E1),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "Tip",
                        tint = Color(0xFFF57F17)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = if (userLanguage == Language.CHICHEWA) guide.emergencyTipChichewa else guide.emergencyTipEnglish,
                        fontSize = (12 * fontScale).sp,
                        color = Color(0xFFE65100),
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

fun triggerPhoneCall(context: Context, phoneNumber: String) {
    try {
        val cleanNumber = phoneNumber.replace(" ", "").replace("-", "")
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$cleanNumber"))
        context.startActivity(intent)
    } catch (_: Exception) {
    }
}
