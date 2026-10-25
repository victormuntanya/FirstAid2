package com.example.firstaid.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BandageLogoIcon(
    size: Dp = 64.dp
) {
    Box(
        modifier = Modifier.size(size),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(size)) {
            val w = this.size.width
            val h = this.size.height

            // Bandage Outer Flesh/Beige Body
            val bandageColor = Color(0xFFE2A87C)
            val padColor = Color(0xFFFFF8F0)
            val crossColor = Color(0xFFD32F2F)
            val dotColor = Color(0xFFC48658)

            // Draw Bandage Pill shape
            val bandageHeight = h * 0.50f
            val bandageWidth = w * 0.98f
            val left = (w - bandageWidth) / 2f
            val top = (h - bandageHeight) / 2f

            drawRoundRect(
                color = bandageColor,
                topLeft = Offset(left, top),
                size = Size(bandageWidth, bandageHeight),
                cornerRadius = CornerRadius(bandageHeight / 2f, bandageHeight / 2f)
            )

            // Draw Adhesive Micro Dots on wings
            val dotRadius = h * 0.040f
            // Left Wing dots
            drawCircle(dotColor, dotRadius, Offset(left + bandageWidth * 0.12f, top + bandageHeight * 0.35f))
            drawCircle(dotColor, dotRadius, Offset(left + bandageWidth * 0.12f, top + bandageHeight * 0.65f))
            drawCircle(dotColor, dotRadius, Offset(left + bandageWidth * 0.22f, top + bandageHeight * 0.50f))

            // Right Wing dots
            drawCircle(dotColor, dotRadius, Offset(left + bandageWidth * 0.88f, top + bandageHeight * 0.35f))
            drawCircle(dotColor, dotRadius, Offset(left + bandageWidth * 0.88f, top + bandageHeight * 0.65f))
            drawCircle(dotColor, dotRadius, Offset(left + bandageWidth * 0.78f, top + bandageHeight * 0.50f))

            // Central Sterile Pad Square
            val padSize = bandageHeight * 0.88f
            val padLeft = (w - padSize) / 2f
            val padTop = (h - padSize) / 2f

            drawRoundRect(
                color = padColor,
                topLeft = Offset(padLeft, padTop),
                size = Size(padSize, padSize),
                cornerRadius = CornerRadius(4f, 4f)
            )

            // Red Cross on Pad
            val crossThickness = padSize * 0.28f
            val crossLength = padSize * 0.72f

            // Vertical arm
            drawRect(
                color = crossColor,
                topLeft = Offset((w - crossThickness) / 2f, (h - crossLength) / 2f),
                size = Size(crossThickness, crossLength)
            )
            // Horizontal arm
            drawRect(
                color = crossColor,
                topLeft = Offset((w - crossLength) / 2f, (h - crossThickness) / 2f),
                size = Size(crossLength, crossThickness)
            )
        }
    }
}

@Composable
fun BandageHeaderTitle(
    subtitleText: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        // Extra Large Prominent Bandage Logo Icon
        BandageLogoIcon(size = 64.dp)

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(
                text = "First Aid MA",
                fontWeight = FontWeight.Bold,
                fontSize = 23.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = subtitleText,
                fontSize = 12.sp,
                color = Color(0xFFB0BEC5)
            )
        }
    }
}
