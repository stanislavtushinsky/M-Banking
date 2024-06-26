package com.example.m_banking.presentation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.m_banking.presentation.components.AccountCard
import com.example.m_banking.presentation.screen.home.HomeScreen
import com.example.m_banking.presentation.theme.MBankingTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MBankingTheme {
                HomeScreen()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AccountCard(title = "sdfsdf", accountNumber = "sdfsdf", cardNumber = "sdfsdf")
}