package com.mmdpuff.pennyflow.ui.components


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import com.mmdpuff.pennyflow.colors
import com.mmdpuff.pennyflow.navigation.Activity
import com.mmdpuff.pennyflow.navigation.Home

@Composable
fun AppBottomBar(
    navController: NavHostController,
    currentDestination: NavDestination?
) {

    val isHomeSelected =
        currentDestination?.hasRoute<Home>() == true

    val isActivitySelected =
        currentDestination?.hasRoute<Activity>() == true

    NavigationBar(
        containerColor = colors.background
    ) {


        NavigationBarItem(
            selected = isHomeSelected,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = colors.accent,
                indicatorColor = colors.surface,
                selectedTextColor = colors.text,
                unselectedTextColor = colors.muted,
                unselectedIconColor = colors.muted
            ),
            onClick = {
                if (!isHomeSelected) {
                    navController.navigate(Home) {

                        popUpTo<Home> {
                            saveState = true
                        }

                        launchSingleTop = true
                        restoreState = true
                    }
                }
            },

            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"
                )
            },

            label = {
                Text("Home")
            }


        )

        NavigationBarItem(
            selected = isActivitySelected,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = colors.accent,
                indicatorColor = colors.surface,
                selectedTextColor = colors.text,
                unselectedTextColor = colors.muted,
                unselectedIconColor = colors.muted
            ),
            onClick = {
                if (!isActivitySelected) {
                    navController.navigate(Activity) {

                        popUpTo<Home> {
                            saveState = true
                        }

                        launchSingleTop = true
                        restoreState = true
                    }
                }
            },

            icon = {
                Icon(
                    imageVector = Icons.Default.History,
                    contentDescription = "Activity"
                )
            },

            label = {
                Text("Activity")
            }
        )
    }
}