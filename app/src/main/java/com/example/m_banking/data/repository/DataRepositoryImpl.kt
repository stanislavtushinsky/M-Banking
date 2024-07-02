package com.example.m_banking.data.repository

import com.example.m_banking.data.dao.CardDao
import com.example.m_banking.data.dao.TransactionDao
import com.example.m_banking.domain.entity.Card
import com.example.m_banking.domain.entity.Transaction
import com.example.m_banking.domain.repository.DataRepository

class DataRepositoryImpl(
    private val transactionDao: TransactionDao,
    private val cardDao: CardDao
) : DataRepository {
    override suspend fun getCards(): List<Card> {
        return cardDao.getCards()
    }

    override suspend fun getTransactions(cardId: Int): List<Transaction> {
        return transactionDao.getTransactions(cardId)
    }

    override suspend fun getTransactionById(transactionId: Int): Transaction {
        return transactionDao.getTransactionById(transactionId)
    }

    override suspend fun addTransaction(transaction: Transaction) {
        transactionDao.insertTransaction(transaction)
    }
}