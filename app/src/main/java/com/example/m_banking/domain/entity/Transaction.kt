package com.example.m_banking.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(
    foreignKeys = [
        ForeignKey(entity = Card::class, parentColumns = ["id"], childColumns = ["cardId"])
    ],
    tableName = "transactions"
)
data class Transaction(
    @ColumnInfo(name = "appliedCompany")
    val appliedCompany: String,

    @ColumnInfo(name = "number")
    val number: String,

    @ColumnInfo(name = "date")
    val date: LocalDate = LocalDate.now(),

    @ColumnInfo(name = "status")
    val status: String,

    @ColumnInfo(name = "amount")
    val amount: Double,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "cardId")
    val cardId: Int
)