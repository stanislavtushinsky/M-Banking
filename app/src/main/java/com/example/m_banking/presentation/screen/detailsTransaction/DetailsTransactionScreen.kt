package com.example.m_banking.presentation.screen.detailsTransaction

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.m_banking.R
import com.example.m_banking.presentation.components.ScrollableColumn
import com.example.m_banking.presentation.navigation.NavigationItem
import com.example.m_banking.presentation.theme.ButtonBackground
import com.example.m_banking.presentation.theme.Typography
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsTransactionScreen(
    navController: NavHostController,
    transactionViewModel: DetailsTransactionViewModel = koinViewModel()
) {
    val transaction by transactionViewModel.selectedTransaction.collectAsState()

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
                value = transaction.appliedCompany,
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    disabledTextColor = Color.White,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                ),
                singleLine = true,
                readOnly = true
            )
            Text(
                text = stringResource(id = R.string.transactionNumber),
                color = Color.White,
                style = Typography.titleSmall
            )
            OutlinedTextField(
                value = transaction.number,
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    disabledTextColor = Color.White,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                ),
                singleLine = true,
                readOnly = true
            )
            Text(
                text = stringResource(id = R.string.dateText),
                color = Color.White,
                style = Typography.titleSmall
            )
            OutlinedTextField(
                value = transaction.date.toString(),
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    disabledTextColor = Color.White,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                ),
                singleLine = true,
                readOnly = true
            )
            Text(
                text = stringResource(id = R.string.transactionStatusText),
                color = Color.White,
                style = Typography.titleSmall
            )
            OutlinedTextField(
                value = transaction.status,
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    disabledTextColor = Color.White,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                ),
                singleLine = true,
                readOnly = true
            )
            Text(
                text = stringResource(id = R.string.amountText),
                color = Color.White,
                style = Typography.titleSmall
            )
            OutlinedTextField(
                value = transaction.amount.toString(),
                onValueChange = {}, modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    disabledTextColor = Color.White,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                ),
                singleLine = true,
                readOnly = true
            )
            Button(
                onClick = {
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
            ) {
                Text(text = stringResource(id = R.string.okayButtonText))
            }
        }
    }
}