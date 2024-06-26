package com.example.m_banking.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.m_banking.R
import com.example.m_banking.presentation.theme.CardBackground
import com.example.m_banking.presentation.theme.DetailsTextColor
import com.example.m_banking.presentation.theme.Typography

@Composable
fun AccountCard(
    title: String,
    accountNumber: String,
    cardNumber: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = CardBackground,
    onClick: () -> Unit = {}
) {
    Card(
        shape = RoundedCornerShape(13.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor,
            contentColor = DetailsTextColor
        ), modifier = Modifier
            .padding(bottom = 23.dp)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_credit_card_24),
                contentDescription = null,
            )
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Column(
                    modifier = Modifier.padding(start = 10.dp)
                ) {
                    Text(text = title, style = Typography.titleSmall, color = Color.White)
                    Text(
                        text = accountNumber,
                        style = Typography.labelSmall,
                        modifier = Modifier.padding(top = 2.dp, bottom = 2.dp)
                    )
                    Text(text = "•••• $cardNumber", style = Typography.labelSmall)
                }
            }
            Image(
                painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                contentDescription = null
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun onPreview() {
    AccountCard("Saving Account", "91212192291221", "1254")
}