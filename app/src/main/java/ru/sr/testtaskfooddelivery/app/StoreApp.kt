package ru.sr.testtaskfooddelivery.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.sr.testtaskfooddelivery.di.appModule
import ru.sr.testtaskfooddelivery.feature_cart.di.cartModule
import ru.sr.testtaskfooddelivery.feature_home.di.homeModule

class StoreApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@StoreApp)
            modules(appModule() + homeModule() + cartModule())
        }
    }
}