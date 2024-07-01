package com.example.m_banking.di.modules

import com.example.m_banking.data.repository.DataRepositoryImpl
import com.example.m_banking.domain.repository.DataRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<DataRepository> {
        DataRepositoryImpl(
            transactionDao = get(),
            cardDao = get()
        )
    }
}