package com.lessons.translatormvp

import android.app.Application
import com.lessons.translatormvp.di.application
import com.lessons.translatormvp.di.mainScreen
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(application, mainScreen))
        }
    }
}