package com.example.myapplication.ui.theme

import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

val Jacquard24FontFamily = FontFamily(
    // Antes: Font(R.font.jacquard24_font_family)
    // Agora, aponte diretamente para o arquivo .ttf
    Font(R.font.jacquard24_regular, FontWeight.Normal)
)

val TexturinaFontFamily = FontFamily(
    Font(R.font.texturina_font_family)
)

val RpgTypography = Typography(
    displayMedium = TextStyle(
        fontFamily = Jacquard24FontFamily,
        fontSize = 36.sp
    ),

    displayLarge = TextStyle(
        fontFamily = Jacquard24FontFamily,
        fontSize = 50.sp
    ),

    titleMedium = TextStyle(
        fontFamily = TexturinaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 26.sp,
    ),

    titleLarge = TextStyle(
        fontFamily = Jacquard24FontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        // A cor será definida no próprio botão
    ),

    bodyLarge = TextStyle(
        fontFamily = TexturinaFontFamily,
        // ... (resto do estilo)
    ),

    labelLarge = TextStyle(
        fontFamily = TexturinaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),

    labelMedium = TextStyle(
        fontFamily = TexturinaFontFamily,
        // ... (resto do estilo)
    )
)
