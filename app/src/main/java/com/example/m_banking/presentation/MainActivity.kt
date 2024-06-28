package com.example.m_banking.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.m_banking.presentation.navigation.AppNavHost
import com.example.m_banking.presentation.theme.MBankingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MBankingTheme {
                AppNavHost(navController = rememberNavController())
            }
        }
    }
}