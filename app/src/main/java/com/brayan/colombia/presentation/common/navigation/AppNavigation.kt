package com.brayan.colombia.presentation.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.brayan.colombia.presentation.common.navigation.AnimationScreen.slideInHorizontally
import com.brayan.colombia.presentation.common.navigation.AnimationScreen.slideOutHorizontally
import com.brayan.colombia.presentation.screens.home.HomeScreen
import com.brayan.colombia.presentation.screens.touristic.TouristicScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home"){
        composable(
            "home",
            enterTransition = { slideInHorizontally },
            exitTransition = { slideOutHorizontally },
        ) {
            HomeScreen(
                navController
            )
        }
        composable(
            "touristic",
            enterTransition = { slideInHorizontally },
            popExitTransition = { slideOutHorizontally },
        ) {
            TouristicScreen(
                navController
            )
        }
    }
}