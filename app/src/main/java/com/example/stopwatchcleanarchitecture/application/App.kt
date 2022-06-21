package com.example.stopwatchcleanarchitecture.application

import android.app.Application
import com.example.stopwatchcleanarchitecture.di.myViewModel
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(myViewModel))
        }
    }
}