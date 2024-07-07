package com.brayan.colombia.presentation.common.navigation

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally

object AnimationScreen {
    val slideOutHorizontally = slideOutHorizontally(
        tween(300),
        targetOffsetX = { it }
    )

    val slideInHorizontally =
        slideInHorizontally(
            tween(300),
            initialOffsetX = { it }
        )

    val fadeInScreen = fadeIn(
        tween(
            700,
            easing = LinearOutSlowInEasing
        )
    )
}