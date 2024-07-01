package com.example.m_banking.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.m_banking.domain.entity.Card

@Dao
interface CardDao {
    @Query("SELECT * from cards")
    suspend fun getCards(): List<Card>
}