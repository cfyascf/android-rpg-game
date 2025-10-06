package com.example.myapplication.ui.theme

import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

val Jacquard24FontFamily = FontFamily(
    Font(R.font.jacquard24_regular, FontWeight.Normal)
)

val Jacquard12FontFamily = FontFamily(
    Font(R.font.jacquard24_font_family)
)

val TexturinaFontFamily = FontFamily(
    Font(R.font.texturina_font_family)
)

val RpgTypography = Typography(
    displayMedium = TextStyle(
        fontFamily = Jacquard24FontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        color = Color.Black
    ),

    displayLarge = TextStyle(
        fontFamily = Jacquard24FontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 52.sp,
        color = Color.Black
    ),

    titleMedium = TextStyle(
        fontFamily = TexturinaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 26.sp,
        color = Color.Black
    ),

    titleLarge = TextStyle(
        fontFamily = TexturinaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        color = Color.Black
    ),

    bodyLarge = TextStyle(
        fontFamily = TexturinaFontFamily,
        color = Color.Black
    ),

    labelLarge = TextStyle(
        fontFamily = TexturinaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        color = Color.Black
    ),

    labelMedium = TextStyle(
        fontFamily = TexturinaFontFamily,
        color = Color.Black
    )
)
