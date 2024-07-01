package com.example.m_banking.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.m_banking.data.dao.CardDao
import com.example.m_banking.data.dao.TransactionDao
import com.example.m_banking.domain.entity.Card
import com.example.m_banking.domain.entity.Transaction
import com.example.m_banking.utils.DateConverter
import java.io.File

@Database(
    entities = [Transaction::class, Card::class],
    version = 1
)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val transactionDao: TransactionDao
    abstract val cardDao: CardDao

    companion object {
        private const val DATABASE_NAME = "database.db"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, DATABASE_NAME
                )
                    .createFromFile(File(context.filesDir, DATABASE_NAME))
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}