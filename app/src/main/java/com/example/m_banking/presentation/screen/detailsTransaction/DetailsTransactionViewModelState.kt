package com.example.m_banking.presentation.screen.detailsTransaction

import com.example.m_banking.domain.entity.Card
import com.example.m_banking.domain.entity.Transaction

data class DetailsTransactionViewModelState(
    val selectedTransaction: Transaction? = null,
    val transactions: List<Transaction> = emptyList(),
    val accountCards: List<Card> = emptyList(),
    val selectedCard: Card? = null
)