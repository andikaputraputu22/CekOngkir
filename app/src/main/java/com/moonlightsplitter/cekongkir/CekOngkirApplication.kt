package com.moonlightsplitter.cekongkir

import android.app.Application
import com.moonlightsplitter.cekongkir.api.Api
import com.moonlightsplitter.cekongkir.api.Client
import com.moonlightsplitter.cekongkir.factory.CityViewModelFactory
import com.moonlightsplitter.cekongkir.factory.CostViewModelFactory
import com.moonlightsplitter.cekongkir.repository.RajaOngkirRepository
import com.moonlightsplitter.cekongkir.tools.SharedPreferencesManager
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import timber.log.Timber

class CekOngkirApplication : Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@CekOngkirApplication))

        bind<Api>() with singleton { Client.instance }
        bind() from singleton { SharedPreferencesManager(instance()) }
        bind() from singleton { RajaOngkirRepository(instance(), instance()) }
        bind() from singleton { CityViewModelFactory(instance()) }
        bind() from singleton { CostViewModelFactory(instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}