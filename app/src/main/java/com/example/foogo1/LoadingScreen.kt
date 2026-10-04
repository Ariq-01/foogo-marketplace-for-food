package com.example.foogo.ui.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foogo.ui.theme.AppColors
import kotlinx.coroutines.delay

@Composable
fun LoadingScreen(
    onLoadingComplete: () -> Unit,
    modifier: Modifier = Modifier
) {
    var startAnimation by remember { mutableStateOf(false) }

    // Efeito de fade/subida simples para o logo
    val alphaAnim by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 800),
        label = "AlphaAnimation"
    )

    // Simulasi Fetch Data (Loading selama 2 detik)
    LaunchedEffect(Unit) {
        startAnimation = true
        delay(2000) // Simulate data loading duration
        onLoadingComplete()
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.PrimaryCyan),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.alpha(alphaAnim)
        ) {
            // Foogo Logo Text
            Text(
                text = "foogo",
                fontSize = 52.sp,
                fontWeight = FontWeight.Black,
                fontFamily = FontFamily.SansSerif,
                color = AppColors.TextPrimary
            )
            
            Spacer(modifier = Modifier.height(4.dp))

            // Subtitle / Indicator sederhana
            Text(
                text = "Fast & Fresh Delivery",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = AppColors.TextPrimary.copy(alpha = 0.7f)
            )
        }
    }
}