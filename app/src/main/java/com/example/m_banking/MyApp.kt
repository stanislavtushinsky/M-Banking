package com.example.m_banking

import android.app.Application
import com.example.m_banking.di.modules.appModule
import com.example.m_banking.di.modules.databaseModule
import com.example.m_banking.di.modules.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(appModule, databaseModule, repositoryModule)
        }
    }
}