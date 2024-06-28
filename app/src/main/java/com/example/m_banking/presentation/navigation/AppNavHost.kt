package com.example.m_banking.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
        composable(NavigationItem.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(NavigationItem.AllTransactions.route) {
            AllTransactionsScreen(navController = navController)
        }
        composable(NavigationItem.AddTransaction.route) {
            AddTransactionScreen(navController = navController)
        }
        composable(NavigationItem.DetailsTransaction.route) {
            DetailsTransactionScreen(
                navController = navController
            )
        }
    }
}