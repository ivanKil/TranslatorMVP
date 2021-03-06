package com.lessons.translatormvp

import android.app.Application
import com.lessons.translatormvp.di.application
import com.lessons.translatormvp.di.historyScreen
import com.lessons.translatormvp.di.mainScreen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(application, mainScreen, historyScreen))
        }
    }
}