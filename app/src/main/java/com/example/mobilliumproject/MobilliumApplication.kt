package com.example.mobilliumproject

import android.app.Application
import com.example.mobilliumproject.Models.RestApi.IService
import com.example.mobilliumproject.Models.RestApi.NetworkConnectionInterceptor
import com.example.mobilliumproject.Models.RestApi.Repository
import com.example.mobilliumproject.viewModelsAndFactory.MobilliumViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MobilliumApplication: Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@MobilliumApplication))
        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { IService(instance()) }
        bind() from  singleton { Repository(instance()) }
        bind() from provider { MobilliumViewModelFactory(instance()) }
    }
}