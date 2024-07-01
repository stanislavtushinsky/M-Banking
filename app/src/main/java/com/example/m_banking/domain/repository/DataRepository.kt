package com.example.m_banking.domain.repository

import com.example.m_banking.domain.entity.Card
import com.example.m_banking.domain.entity.Transaction

interface DataRepository {
    suspend fun getCards(): List<Card>

    suspend fun getTransactions(cardId: Int): List<Transaction>

    suspend fun getTransactionById(transactionId: Int): Transaction

    suspend fun addTransaction(transaction: Transaction)
}