package com.example.m_banking.presentation.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.m_banking.R
import com.example.m_banking.presentation.components.AccountCard
import com.example.m_banking.presentation.components.TransactionCard
import com.example.m_banking.presentation.navigation.NavigationItem
import com.example.m_banking.presentation.screen.accountSelection.AccountSelection
import com.example.m_banking.presentation.screen.detailsTransaction.DetailsTransactionViewModel
import com.example.m_banking.presentation.theme.ButtonBackground
import com.example.m_banking.presentation.theme.CardBackground
import com.example.m_banking.presentation.theme.Typography
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    navController: NavHostController,
    transactionViewModel: DetailsTransactionViewModel = koinViewModel()
) {
    val state by transactionViewModel.state.collectAsState()
    var isSheetOpen by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 12.dp, bottom = 12.dp, start = 16.dp, end = 16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.accountText),
            color = Color.White,
            style = Typography.titleMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        )
        AccountCard(
            title = state.selectedCard?.name ?: "",
            accountNumber = state.selectedCard?.accountNumber ?: "",
            cardNumber = state.selectedCard?.cardNumber ?: "",
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.18f),
            onClick = {
                isSheetOpen = true
            }
        )
        if (isSheetOpen) {
            AccountSelection(
                onDismissRequest = { isSheetOpen = false },
                accountCards = state.accountCards,
                onAccountSelected = { card ->
                    transactionViewModel.selectCard(card)
                    isSheetOpen = false
                }
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.recentTransactionsText),
                color = Color.White,
                style = Typography.titleSmall
            )
            Text(
                text = stringResource(id = R.string.viewAllText),
                color = ButtonBackground,
                style = Typography.labelSmall,
                modifier = Modifier.clickable {
                    state.selectedCard?.let {
                        navController.navigate(NavigationItem.AllTransactions.createRoute((it.id)))
                    }
                }
            )
        }
        Card(
            shape = RoundedCornerShape(13.dp),
            colors = CardDefaults.cardColors(
                containerColor = CardBackground
            ),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            LazyColumn(
                modifier = Modifier.padding(16.dp)
            ) {
                itemsIndexed(items = state.transactions.take(5)) { index, item ->
                    TransactionCard(
                        appliedCompany = item.appliedCompany,
                        date = item.date,
                        status = item.status,
                        amount = item.amount,
                        onClick = {
                            transactionViewModel.selectTransaction(item)
                            navController.navigate(NavigationItem.DetailsTransaction.route)
                        }
                    )
                    if (index < state.transactions.take(5).lastIndex)
                        Divider(
                            color = Color.LightGray,
                            thickness = 0.3.dp,
                            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
                        )
                }
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(end = 16.dp, bottom = 12.dp)
    ) {
        FloatingActionButton(
            onClick = {
                navController.navigate(
                    NavigationItem.AddTransaction.createRoute(
                        state.selectedCard?.id
                            ?: 0
                    )
                )
            },
            shape = CircleShape,
            containerColor = ButtonBackground,
            contentColor = Color.White,
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_add_24),
                contentDescription = null
            )
        }
    }
}