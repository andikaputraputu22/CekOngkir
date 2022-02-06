package com.moonlightsplitter.cekongkir

import android.app.Application
import timber.log.Timber

class CekOngkirApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}