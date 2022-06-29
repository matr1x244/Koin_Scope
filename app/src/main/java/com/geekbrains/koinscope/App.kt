package com.geekbrains.koinscope

import android.app.Application
import com.geekbrains.koinscope.di.koin.ModuleKoin
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(ModuleKoin.mainScope)
        }
    }
}