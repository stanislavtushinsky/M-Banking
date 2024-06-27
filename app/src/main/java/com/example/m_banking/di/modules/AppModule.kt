package com.example.m_banking.di.modules

import com.example.m_banking.presentation.screen.detailsTransaction.DetailsTransactionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { DetailsTransactionViewModel() }
}