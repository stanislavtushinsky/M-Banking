package com.example.m_banking.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.m_banking.domain.entity.Card
import com.example.m_banking.domain.entity.Transaction
import java.time.LocalDate
import java.time.Month

class DataRepositoryImpl {
    fun getAccountCards(): List<Card> {
        return listOf(
            Card(
                name = "My first account",
                accountNumber = "1234567890",
                cardNumber = "1234"
            ),
            Card(
                name = "For travelling",
                accountNumber = "0987654321",
                cardNumber = "4321"
            ),
            Card(
                name = "Saving Account ",
                accountNumber = "193454321",
                cardNumber = "5424"
            )
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getTransactions(): List<Transaction> {
        return listOf(
            Transaction(
                appliedCompany = "OOO “Company1",
                number = "wfdr4rjfshjek3er4",
                date = LocalDate.of(2021, Month.MAY, 3),
                status = "Declined",
                amount = 54.99
            ),
            Transaction(
                appliedCompany = "OOO “Company2",
                number = "f4345jfshjek3454",
                date = LocalDate.of(2021, Month.MAY, 5),
                status = "In progress",
                amount = 10.99
            ),
            Transaction(
                appliedCompany = "OOO “Company3",
                number = "sdg345SSDFrgek3454",
                date = LocalDate.of(2021, Month.MAY, 5),
                status = "Declined" ,
                amount = 234.99
            ),
            Transaction(
                appliedCompany = "OOO “Company4",
                number = "f434535tfshSDGsSDk3G454",
                date = LocalDate.of(2021, Month.MAY, 6),
                status = "Executed" ,
                amount = 0.99
            ),
            Transaction(
                appliedCompany = "OOO “Company5",
                number = "jfdfsh234jek3454",
                date = LocalDate.of(2021, Month.MAY, 8),
                status = "Declined" ,
                amount = 13.39
            )
        )
    }
}