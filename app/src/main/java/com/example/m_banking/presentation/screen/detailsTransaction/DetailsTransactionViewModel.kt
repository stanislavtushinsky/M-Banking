package com.example.m_banking.presentation.screen.detailsTransaction

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.m_banking.domain.entity.Card
import com.example.m_banking.domain.entity.Transaction
import com.example.m_banking.domain.repository.DataRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailsTransactionViewModel(private val dataRepository: DataRepository) : ViewModel() {
    private val _selectedTransaction = MutableStateFlow<Transaction?>(null)
    val selectedTransaction: StateFlow<Transaction?> = _selectedTransaction

    private val _transactions = MutableStateFlow<List<Transaction>>(emptyList())
    val transactions: StateFlow<List<Transaction>> = _transactions

    private val _accountCards = MutableStateFlow<List<Card>>(emptyList())
    val accountCards: StateFlow<List<Card>> = _accountCards

    private val _selectedCard = MutableStateFlow<Card?>(null)
    val selectedCard: StateFlow<Card?> = _selectedCard

    init {
        fetchAccountCards()
    }

    fun selectTransaction(transaction: Transaction) {
        viewModelScope.launch {
            _selectedTransaction.emit(transaction)
        }
    }

    fun selectCard(card: Card) {
        viewModelScope.launch {
            _selectedCard.emit(card)
            fetchTransactions(card.id)
        }
    }

    private fun fetchTransactions(cardId: Int) {
        viewModelScope.launch {
            _transactions.value = dataRepository.getTransactions(cardId)
        }
    }

    private fun fetchAccountCards() {
        viewModelScope.launch {
            _accountCards.value = dataRepository.getCards()
        }
    }
}