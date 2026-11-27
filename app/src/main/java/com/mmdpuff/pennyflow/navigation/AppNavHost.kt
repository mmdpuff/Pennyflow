package com.mmdpuff.pennyflow.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.mmdpuff.pennyflow.feature.activity.ActivityScreen
import com.mmdpuff.pennyflow.feature.home.HomeScreen
import com.mmdpuff.pennyflow.feature.setup.SetupScreen
import com.mmdpuff.pennyflow.ui.components.AppBottomBar

@Composable
fun AppNavHost() {

    // Navigation Controller
    val navController = rememberNavController()

    // Current Destination
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentDestination = backStackEntry?.destination

    // Bottom Navigation Visibility
    val showBottomBar =
        currentDestination?.let {
            it.hasRoute<Home>() || it.hasRoute<Activity>()
        } == true

    Scaffold(

        bottomBar = {

            if (showBottomBar) {

                AppBottomBar(
                    navController = navController,
                    currentDestination = currentDestination
                )
            }
        }

    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = SetUp,
            modifier = Modifier.padding(innerPadding)
        ) {

            // Setup Screen
            composable<SetUp> {

                SetupScreen(

                    onContinue = {

                        navController.navigate(MainGraph) {

                            popUpTo<SetUp> {
                                inclusive = true
                            }

                            launchSingleTop = true
                        }
                    }
                )
            }

            // Main Application Graph
            navigation<MainGraph>(
                startDestination = Home
            ) {

                composable<Home> {
                    HomeScreen()
                }

                composable<Activity> {
                    ActivityScreen()
                }
            }
        }
    }
}