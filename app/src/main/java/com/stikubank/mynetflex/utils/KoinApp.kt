package com.stikubank.mynetflex.utils

import android.app.Application
import com.stikubank.mynetflex.di.jsonHelperModule
import com.stikubank.mynetflex.di.repositoryModule
import com.stikubank.mynetflex.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class KoinApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@KoinApp)
            modules(
                    listOf(
                            jsonHelperModule,
                            repositoryModule,
                            viewModelModule
                    )
            )
        }
    }
}