package com.example.m_banking.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.m_banking.presentation.screen.addTransaction.AddTransactionScreen
import com.example.m_banking.presentation.screen.allTransactions.AllTransactionsScreen
import com.example.m_banking.presentation.screen.detailsTransaction.DetailsTransactionScreen
import com.example.m_banking.presentation.screen.home.HomeScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String = NavigationItem.Home.route
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = NavigationItem.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(
            route = NavigationItem.AllTransactions.route,
            arguments = listOf(navArgument("cardId") { type = NavType.IntType })
        ) { backStackEntry ->
            val cardId = backStackEntry.arguments?.getInt("cardId") ?: return@composable
            AllTransactionsScreen(navController = navController, selectedCardId = cardId)
        }

        composable(
            route = NavigationItem.AddTransaction.route,
            arguments = listOf(navArgument("cardId") { type = NavType.IntType })
        ) { backStackEntry ->
            val cardId = backStackEntry.arguments?.getInt("cardId") ?: return@composable
            AddTransactionScreen(navController = navController, selectedCardId = cardId)
        }

        composable(route = NavigationItem.DetailsTransaction.route) {
            DetailsTransactionScreen(
                navController = navController
            )
        }
    }
}