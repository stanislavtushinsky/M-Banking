package com.example.m_banking.presentation.screen.addTransaction

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.m_banking.R
import com.example.m_banking.domain.entity.Transaction
import com.example.m_banking.presentation.components.ScrollableColumn
import com.example.m_banking.presentation.navigation.NavigationItem
import com.example.m_banking.presentation.theme.ButtonBackground
import com.example.m_banking.presentation.theme.Typography
import org.koin.androidx.compose.koinViewModel
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTransactionScreen(
    navController: NavHostController,
    selectedCardId: Int,
    viewModel: AddTransactionViewModel = koinViewModel()
) {
    var appliedCompany by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    val isInputEmpty = appliedCompany.isEmpty() || number.isEmpty() || date.isEmpty() || status.isEmpty() || amount.isEmpty()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ScrollableColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = stringResource(id = R.string.transactionText),
                color = Color.White,
                style = Typography.titleMedium
            )
            Text(
                text = stringResource(id = R.string.transactionAppliedText),
                color = Color.White,
                style = Typography.titleSmall
            )
            OutlinedTextField(
                value = appliedCompany,
                onValueChange = { appliedCompany = it },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    disabledTextColor = Color.White,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                ),
                singleLine = true
            )
            Text(
                text = stringResource(id = R.string.transactionNumber),
                color = Color.White,
                style = Typography.titleSmall
            )
            OutlinedTextField(
                value = number,
                onValueChange = { number = it },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    disabledTextColor = Color.White,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                ),
                singleLine = true
            )
            Text(
                text = stringResource(id = R.string.dateText),
                color = Color.White,
                style = Typography.titleSmall
            )
            OutlinedTextField(
                value = date,
                onValueChange = { date = it },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    disabledTextColor = Color.White,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                ),
                singleLine = true
            )
            Text(
                text = stringResource(id = R.string.transactionStatusText),
                color = Color.White,
                style = Typography.titleSmall
            )
            OutlinedTextField(
                value = status,
                onValueChange = { status = it },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    disabledTextColor = Color.White,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                ),
                singleLine = true
            )
            Text(
                text = stringResource(id = R.string.amountText),
                color = Color.White,
                style = Typography.titleSmall
            )
            OutlinedTextField(
                value = amount,
                onValueChange = { amount = it }, modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    disabledTextColor = Color.White,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                ),
                singleLine = true
            )
            Button(
                onClick = {
                    val transaction = Transaction(
                        appliedCompany = appliedCompany,
                        number = number,
                        date = LocalDate.parse(date),
                        status = status,
                        amount = amount.toDouble(),
                        cardId = selectedCardId
                    )
                    viewModel.addTransaction(transaction)
                    navController.navigate(NavigationItem.Home.route) {
                        popUpTo(NavigationItem.Home.route) { inclusive = true }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ButtonBackground,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp),
                enabled = !isInputEmpty
            ) {
                Text(text = stringResource(id = R.string.okayButtonText))
            }
        }
    }
}