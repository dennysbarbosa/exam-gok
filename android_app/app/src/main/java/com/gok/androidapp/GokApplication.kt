package com.gok.androidapp

import android.app.Application
import com.gok.androidapp.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class GokApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@GokApplication)

            modules(mainModule)
        }
    }
}