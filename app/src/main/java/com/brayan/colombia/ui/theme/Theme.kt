package com.brayan.colombia.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun ColombiaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colors = colors

    CompositionLocalProvider(
        LocalColors provides colors,
    ) {
        MaterialTheme(
            colorScheme = darkColorScheme(),
            content = content
        )
    }
}


object ColombiaTheme {
    val colors: Colors
        @Composable
        get() = LocalColors.current
}