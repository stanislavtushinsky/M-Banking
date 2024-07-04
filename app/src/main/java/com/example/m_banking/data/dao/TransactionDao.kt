package com.example.m_banking.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.m_banking.domain.entity.Transaction

@Dao
interface TransactionDao {
    @Insert
    suspend fun insertTransaction(transaction: Transaction)

    @Query("SELECT * from transactions where cardId = :cardId")
    suspend fun getTransactions(cardId: Int): List<Transaction>

    @Query("SELECT * from transactions where id = :transactionId")
    suspend fun getTransactionById(transactionId: Int): Transaction

    @Query("SELECT * from transactions where date between :startDate and :endDate")
    suspend fun getTransactionsByDate(startDate: String?, endDate: String?): List<Transaction>
}