package com.example.m_banking.presentation.screen.addTransaction

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.m_banking.domain.entity.Transaction
import com.example.m_banking.domain.repository.DataRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate

class AddTransactionViewModel(private val dataRepository: DataRepository) : ViewModel() {
    private val _addedTransaction = MutableStateFlow(Transaction("", "", LocalDate.now(), "", 0.0, cardId = 1))
    val addedTransaction: StateFlow<Transaction> = _addedTransaction

    fun addTransaction(transaction: Transaction) {
        viewModelScope.launch {
            _addedTransaction.emit(transaction)
            dataRepository.addTransaction(transaction)
        }
    }
}