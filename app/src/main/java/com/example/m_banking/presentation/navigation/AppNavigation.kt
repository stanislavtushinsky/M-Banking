package com.example.m_banking.presentation.navigation

sealed class NavigationItem(val route: String) {
    data object Home : NavigationItem(route = "home_screen")

    data object AllTransactions : NavigationItem(route = "all_transactions/{cardId}") {
        fun createRoute(cardId: Int) = "all_transactions/$cardId"
    }

    data object AddTransaction : NavigationItem(route = "add_transactions/{cardId}") {
        fun createRoute(cardId: Int) = "add_transactions/$cardId"
    }

    data object DetailsTransaction : NavigationItem(route = "details_transaction")
}