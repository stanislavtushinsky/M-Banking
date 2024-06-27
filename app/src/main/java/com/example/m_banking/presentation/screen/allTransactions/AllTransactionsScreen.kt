package com.example.m_banking.presentation.screen.allTransactions

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.m_banking.R
import com.example.m_banking.data.repository.DataRepositoryImpl
import com.example.m_banking.presentation.components.TransactionCard
import com.example.m_banking.presentation.theme.CardBackground
import com.example.m_banking.presentation.theme.Typography

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AllTransactionsScreen() {
    val dataRepository = DataRepositoryImpl()
    val transactionCards = dataRepository.getTransactions()
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 22.dp, end = 22.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_keyboard_arrow_left_24),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
            )
            Text(
                text = stringResource(id = R.string.allTransactionsText),
                color = Color.White,
                style = Typography.titleSmall,
                modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_filter_alt_24),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
        Card(
            shape = RoundedCornerShape(13.dp),
            colors = CardDefaults.cardColors(
                containerColor = CardBackground
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 12.dp, end = 12.dp)
        ) {
            LazyColumn(
                modifier = Modifier.padding(16.dp)
            ) {
                items(transactionCards) { _ ->
                    TransactionCard(
                        appliedCompany = transactionCards.first().appliedCompany,
                        date = transactionCards.first().date,
                        status = transactionCards.first().status,
                        amount = transactionCards.first().amount
                    )
                    Divider(
                        color = Color.LightGray,
                        thickness = 0.4.dp,
                        modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
                    )
                }
            }
        }
    }
}