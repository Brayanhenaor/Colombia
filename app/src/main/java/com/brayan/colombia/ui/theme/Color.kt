package com.brayan.colombia.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)


@Immutable
data class Colors(
    val black: Color,
    val green: Color,
    val blue: Color,
    val khaki: Color,
    val rose: Color,
    val darkBlue: Color,
)

val LocalColors = staticCompositionLocalOf {
    Colors(
        black = Color.Unspecified,
        green = Color.Unspecified,
        blue = Color.Unspecified,
        khaki = Color.Unspecified,
        rose = Color.Unspecified,
        darkBlue = Color.Unspecified,
    )
}

val colors = Colors(
    black = Color(0xFF06070E),
    blue = Color(0xFF94A187),
    green = Color(0xFF29524A),
    khaki = Color(0xFFC5AFA0),
    rose = Color(0xFFE9BCB7),
    darkBlue = Color(0xFF0A1229),
)
