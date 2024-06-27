package com.example.m_banking.presentation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.compose.rememberNavController
import com.example.m_banking.presentation.navigation.AppNavigation
import com.example.m_banking.presentation.theme.MBankingTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MBankingTheme {
                val navController = rememberNavController()
                AppNavigation(navController = navController)
            }
        }
    }
}