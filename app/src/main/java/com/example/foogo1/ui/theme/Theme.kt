package com.example.foogo.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// ==========================================
// 1. COLOR PALETTE MODULAR
// ==========================================
object AppColors {
    val PrimaryCyan = Color(0xFF13E2C4)       // Warna utama "foogo" Toska/Cyan
    val SecondaryCyan = Color(0xFFE0FBF7)     // Latar belakang Cyan lembut
    val BackgroundLight = Color(0xFFF6F7F9)   // Warna latar layar
    val CardBackground = Color(0xFFFFFFFF)    // Warna kartu putih
    val TextPrimary = Color(0xFF191919)       // Teks hitam utama
    val TextSecondary = Color(0xFF767676)     // Teks abu-abu
    val TextMuted = Color(0xFF9E9E9E)         // Teks abu-abu muda
    val AccentOrange = Color(0xFFFF6B00)      // Warna aksen promo / diskon
    val AccentRed = Color(0xFFFF3B30)         // Warna tag pembatalan/alert
    val DividerColor = Color(0xFFEEEEEE)      // Warna garis pemisah
    val StarYellow = Color(0xFFFFB800)        // Warna rating bintang
}

// ==========================================
// 2. TYPOGRAPHY / TEXT STYLES MODULAR
// ==========================================
object AppTypography {
    val HeaderTitle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        color = AppColors.TextPrimary
    )
    val SectionTitle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        color = AppColors.TextPrimary
    )
    val ItemTitle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = AppColors.TextPrimary
    )
    val BodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = AppColors.TextPrimary
    )
    val BodySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = AppColors.TextSecondary
    )
    val Caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        color = AppColors.TextMuted
    )
    val ButtonText = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 13.sp
    )
}

// ==========================================
// 3. SHAPES / CORNER RADIUS MODULAR
// ==========================================
object AppShapes {
    val Small = RoundedCornerShape(8.dp)
    val Medium = RoundedCornerShape(12.dp)
    val Large = RoundedCornerShape(16.dp)
    val ExtraLarge = RoundedCornerShape(24.dp)
    val Pill = RoundedCornerShape(50)
}

// ==========================================
// 4. MAIN THEME WRAPPER
// ==========================================
private val LightColorScheme = lightColorScheme(
    primary = AppColors.PrimaryCyan,
    background = AppColors.BackgroundLight,
    surface = AppColors.CardBackground,
    onPrimary = Color.White,
    onBackground = AppColors.TextPrimary,
    onSurface = AppColors.TextPrimary
)

@Composable
fun FoogoTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        content = content
    )
}