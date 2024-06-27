package com.example.m_banking.presentation.screen.accountSelection

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.m_banking.R
import com.example.m_banking.domain.entity.Card
import com.example.m_banking.presentation.components.AccountCard
import com.example.m_banking.presentation.theme.CardBackground
import com.example.m_banking.presentation.theme.CardSelectedBackground
import com.example.m_banking.presentation.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountSelection(
    onDismissRequest: () -> Unit,
    accountCards: List<Card>
) {
    var selectedAccount by remember { mutableStateOf<Card?>(null) }

    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        containerColor = Color.Black
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.selectAccountText),
                style = Typography.titleLarge,
                color = Color.White,
                modifier = Modifier.padding(bottom = 32.dp)
            )
            LazyColumn(
                modifier = Modifier.padding(16.dp)
            ) {
                items(accountCards) { account ->
                    AccountCard(
                        title = accountCards.first().name,
                        accountNumber = accountCards.first().accountNumber,
                        cardNumber = accountCards.first().cardNumber,
                        backgroundColor = if (selectedAccount == account) CardSelectedBackground else CardBackground,
                        onClick = {
                            selectedAccount = account
                        }
                    )
                }
            }
        }
    }
}