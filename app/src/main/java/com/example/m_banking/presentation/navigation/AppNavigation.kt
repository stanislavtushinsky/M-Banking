package com.example.m_banking.presentation.navigation

enum class Screen {
    HOME, ALL_TRANSACTIONS, ADD_TRANSACTION, DETAILS_TRANSACTION
}

sealed class NavigationItem(val route: String) {
    data object Home : NavigationItem(Screen.HOME.name)
    data object AllTransactions : NavigationItem(Screen.ALL_TRANSACTIONS.name)
    data object AddTransaction : NavigationItem(Screen.ADD_TRANSACTION.name)
    data object DetailsTransaction : NavigationItem(Screen.DETAILS_TRANSACTION.name)
}