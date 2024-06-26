package com.example.m_banking.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.m_banking.R

val Typography = Typography(
    titleMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.lato_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 37.sp,
        lineHeight = 45.sp,
        letterSpacing = 0.sp
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.lato_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 37.sp,
        letterSpacing = 0.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.lato_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 45.sp,
        lineHeight = 55.sp,
        letterSpacing = 0.sp
    ),
    titleSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.lato_regular)),
        fontWeight = FontWeight.Medium,
        fontSize = 23.sp,
        lineHeight = 29.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.lato_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    )
)