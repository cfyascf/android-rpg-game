package com.example.myapplication.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val RpgLightColorScheme = lightColorScheme(
    primary = GoldColor,
    background = DarkBackgroundColor,
    surface = ParchmentColor,
    onPrimary = DarkBrownColor,
    onBackground = ParchmentColor,
    onSurface = DarkBrownColor
)

private val RpgDarkColorScheme = darkColorScheme(
    primary = GoldColor,
    background = DarkBackgroundColor,
    surface = ParchmentColor,
    onPrimary = DarkBrownColor,
    onBackground = ParchmentColor,
    onSurface = DarkBrownColor
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        RpgDarkColorScheme
    } else {
        RpgLightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = RpgTypography,
        content = content
    )
}