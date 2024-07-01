package com.example.m_banking.di.modules

import androidx.room.Room
import com.example.m_banking.data.dao.CardDao
import com.example.m_banking.data.dao.TransactionDao
import com.example.m_banking.data.database.AppDatabase
import org.koin.dsl.module

val databaseModule = module {
    single<AppDatabase> {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    single<TransactionDao> {
        get<AppDatabase>().transactionDao
    }

    single<CardDao> {
        get<AppDatabase>().cardDao
    }
}