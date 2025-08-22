package com.example.daysketcher

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import com.example.daysketcher.di.appModule

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            modules(appModule) // тука оди твојот AppModule.kt
        }
    }
}
