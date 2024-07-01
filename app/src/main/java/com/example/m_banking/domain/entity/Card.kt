package com.example.m_banking.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cards")
data class Card(
    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "accountNumber")
    val accountNumber: String,

    @ColumnInfo(name = "cardNumber")
    val cardNumber: String,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)