package com.example.m_banking.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.m_banking.presentation.screen.addTransaction.AddTransactionScreen
import com.example.m_banking.presentation.screen.allTransactions.AllTransactionsScreen
import com.example.m_banking.presentation.screen.detailsTransaction.DetailsTransactionScreen
import com.example.m_banking.presentation.screen.detailsTransaction.DetailsTransactionViewModel
import com.example.m_banking.presentation.screen.home.HomeScreen

@Composable
fun AppNavigation(
    navController: NavHostController
) {
    val transactionViewModel: DetailsTransactionViewModel = viewModel()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController = navController, transactionViewModel = transactionViewModel)
        }
        composable("allTransactions") {
            AllTransactionsScreen(navController = navController)
        }
        composable("addTransaction") {
            AddTransactionScreen(navController = navController)
        }
        composable("detailsTransaction") {
            DetailsTransactionScreen(
                navController = navController,
                transactionViewModel = transactionViewModel
            )
        }
    }
}