package com.brayan.colombia.presentation.common.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun HeadingText(
    text: String,
    color: Color = Color.White,
    modifier: Modifier = Modifier
){
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = 27.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}