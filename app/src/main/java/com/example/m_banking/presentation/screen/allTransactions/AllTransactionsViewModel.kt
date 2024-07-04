package com.example.m_banking.presentation.screen.allTransactions

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.m_banking.domain.entity.Transaction
import com.example.m_banking.domain.repository.DataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AllTransactionsViewModel(private val dataRepository: DataRepository) : ViewModel() {
    private val _transactions = MutableStateFlow<List<Transaction>>(emptyList())
    val transactions: StateFlow<List<Transaction>> = _transactions

    private val _selectedCardId = MutableStateFlow<Int?>(null)
    val selectedCardId: StateFlow<Int?> = _selectedCardId

    init {
        fetchTransactions()
    }


    fun setSelectedCardId(cardId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _selectedCardId.emit(cardId)
            fetchTransactions(cardId)
        }
    }

    fun filterTransactionsByDateRange(startDate: String?, endDate: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            val filteredTransactions = dataRepository.getTransactionsByDate(startDate, endDate)
            Log.i(ContentValues.TAG, "allTransactions VM ${filteredTransactions.size}")
            _transactions.emit(filteredTransactions)
        }
    }

    private fun fetchTransactions(cardId: Int? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            if (cardId != null) {
                _transactions.value = dataRepository.getTransactions(cardId)
            } else {
                _transactions.value = emptyList()
            }
        }
    }
}