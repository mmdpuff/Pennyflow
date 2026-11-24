package com.mmdpuff.pennyflow.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mmdpuff.pennyflow.R


val Inter = FontFamily(
    Font(resId = R.font.inter_semibold, FontWeight.SemiBold),
    Font(resId = R.font.inter_regular, FontWeight.Normal),
    Font(resId = R.font.inter_medium, FontWeight.Medium),

    )

val AppTypography = Typography(
    bodyLarge = Typography().bodyLarge.copy(
        color = TextColor,
        fontFamily = Inter
    ),
    bodyMedium = Typography().bodyMedium.copy(
        color = TextColor,
        fontFamily = Inter
    ),
    bodySmall = Typography().bodySmall.copy(
        color = TextColor,
        fontFamily = Inter
    ),

    titleLarge = Typography().titleLarge.copy(
        color = TextColor,
        fontFamily = Inter
    ),
    titleMedium = Typography().titleMedium.copy(
        color = TextColor,
        fontFamily = Inter
    ),
    titleSmall = Typography().titleSmall.copy(
        color = TextColor,
        fontFamily = Inter
    ),

    headlineLarge = Typography().headlineLarge.copy(
        color = TextColor,
        fontFamily = Inter
    ),
    headlineMedium = Typography().headlineMedium.copy(
        color = TextColor,
        fontFamily = Inter
    ),
    headlineSmall = Typography().headlineSmall.copy(
        color = TextColor,
        fontFamily = Inter
    ),

    labelLarge = Typography().labelLarge.copy(
        color = TextColor,
        fontFamily = Inter
    ),
    labelMedium = Typography().labelMedium.copy(
        color = TextColor,
        fontFamily = Inter
    ),
    labelSmall = Typography().labelSmall.copy(
        color = TextColor,
        fontFamily = Inter
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        color = TextColor,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)