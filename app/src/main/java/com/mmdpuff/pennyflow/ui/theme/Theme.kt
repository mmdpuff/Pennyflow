package com.mmdpuff.pennyflow.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext
import com.mmdpuff.pennyflow.ui.data.color
import com.mmdpuff.pennyflow.ui.models.AppColors

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryColor,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = BackgroundColorDark
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryColor,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = BackgroundColorDark
)

val DarkAppColors = AppColors(
    background = BackgroundColorDark,
    accent = 0xB9F46D.color,
    text = 0xF7F9FC.color,
    muted = 0xA6B2C3.color,
    surface = 0x162131.color,
    border = 0x29364A.color

)

//val LightAppColors = AppColors(
//    success = Color.White,
//    warning = Color(0xFFF9A825),
//    card = Color(0xFFFFFFFF),
//    border = Color(0xFFE0E0E0)
//)

val LocalAppColors = staticCompositionLocalOf {
    DarkAppColors
}

@Composable
fun PennyflowTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (darkTheme) dynamicDarkColorScheme(context)
            else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val appColors = if (darkTheme) DarkAppColors else DarkAppColors

    CompositionLocalProvider(
        LocalAppColors provides appColors
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = AppTypography,
            content = content
        )
    }
}