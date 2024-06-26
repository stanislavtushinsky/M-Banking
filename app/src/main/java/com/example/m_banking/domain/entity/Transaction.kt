package com.example.m_banking.domain.entity

import java.time.LocalDate

data class Transaction (
    val appliedCompany: String,
    val number: String,
    val date: LocalDate,
    val status: String,
    val amount: Double
)