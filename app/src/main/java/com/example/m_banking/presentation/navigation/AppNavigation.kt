package com.example.m_banking.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.m_banking.presentation.screen.addTransaction.AddTransactionScreen
import com.example.m_banking.presentation.screen.allTransactions.AllTransactionsScreen
import com.example.m_banking.presentation.screen.home.HomeScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigation(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("allTransactions") {
            AllTransactionsScreen(navController = navController)
        }
        composable("addTransaction"){
            AddTransactionScreen(navController = navController)
        }
    }
}