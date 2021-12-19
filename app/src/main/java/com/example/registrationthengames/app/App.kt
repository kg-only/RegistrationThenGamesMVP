package com.example.registrationthengames.app

import android.app.Application
import com.example.registrationthengames.common.CommonModule
import com.example.registrationthengames.main.ui.MainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@App)
            modules(MainModule.create(), CommonModule.create())
        }
    }
}