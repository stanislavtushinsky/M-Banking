package com.example.m_banking.presentation.screen.detailsTransaction

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.m_banking.domain.entity.Transaction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate

class DetailsTransactionViewModel : ViewModel() {
    private val _selectedTransaction = MutableStateFlow(Transaction("", "", LocalDate.now(), "", 0.0))
    val selectedTransaction: StateFlow<Transaction> = _selectedTransaction

    fun selectTransaction(transaction: Transaction) {
        viewModelScope.launch {
            _selectedTransaction.emit(transaction)
        }
    }
}