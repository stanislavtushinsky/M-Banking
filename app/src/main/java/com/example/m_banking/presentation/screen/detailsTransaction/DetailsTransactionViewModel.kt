package com.example.m_banking.presentation.screen.detailsTransaction

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.m_banking.domain.entity.Card
import com.example.m_banking.domain.entity.Transaction
import com.example.m_banking.domain.repository.DataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailsTransactionViewModel(private val dataRepository: DataRepository) : ViewModel() {
    private val _state = MutableStateFlow(DetailsTransactionViewModelState())
    val state: StateFlow<DetailsTransactionViewModelState> = _state

    init {
        fetchAccountCards()
    }

    fun selectTransaction(transaction: Transaction) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(selectedTransaction = transaction) }
        }
    }

    fun selectCard(card: Card) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(selectedCard = card) }
            fetchTransactions(card.id)
        }
    }

    private fun fetchTransactions(cardId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(transactions = dataRepository.getTransactions(cardId)) }
        }
    }

    private fun fetchAccountCards() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(accountCards = dataRepository.getCards()) }
        }
    }
}