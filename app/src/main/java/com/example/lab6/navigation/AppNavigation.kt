package com.example.lab6.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lab6.screens.PersonDetailScreen
import com.example.lab6.screens.PersonEditScreen
import com.example.lab6.screens.PersonListScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "list"
    ) {
        composable("list") {
            PersonListScreen(navController)
        }
        composable(
            "detail/{personId}",
            arguments = listOf(navArgument("personId") { type = NavType.IntType })
        ) { backStackEntry ->
            PersonDetailScreen(
                personId = backStackEntry.arguments?.getInt("personId") ?: 0,
                navController = navController
            )
        }
        composable(
            "edit/{personId}",
            arguments = listOf(navArgument("personId") {
                type = NavType.IntType
                defaultValue = 0
                nullable = false
            })
        ) { backStackEntry ->
            PersonEditScreen(
                personId = backStackEntry.arguments?.getInt("personId") ?: 0,
                navController = navController
            )
        }
    }
}