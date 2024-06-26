package com.example.m_banking.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.m_banking.R
import com.example.m_banking.presentation.theme.CardBackground
import com.example.m_banking.presentation.theme.DeclinedTextColor
import com.example.m_banking.presentation.theme.ExecutedTextColor
import com.example.m_banking.presentation.theme.InProgressTextColor
import com.example.m_banking.presentation.theme.Typography
import java.time.LocalDate

@Composable
fun TransactionCard(
    appliedCompany: String,
    date: LocalDate,
    status: String,
    amount: Double
) {
    Box(
        modifier = Modifier
            .background(color = CardBackground)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier, verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = appliedCompany,
                    style = Typography.titleSmall,
                    color = Color.White,
                )
                Text(
                    text = date.toString(),
                    style = Typography.labelSmall,
                    color = Color.Gray
                )
                Text(
                    text = status,
                    style = Typography.labelSmall,
                    color = when (status) {
                        "Executed" -> ExecutedTextColor
                        "In progress" -> InProgressTextColor
                        "Declined" -> DeclinedTextColor
                        else -> Color.Gray
                    }
                )
            }
            Row(
                modifier = Modifier.align(Alignment.Top),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$$amount",
                    style = Typography.titleSmall,
                    color = Color.White,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                    contentDescription = null
                )
            }
        }
    }
}
