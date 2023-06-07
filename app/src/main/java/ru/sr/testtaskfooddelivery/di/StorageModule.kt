package ru.sr.testtaskfooddelivery.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.sr.testtaskfooddelivery.local.StoreDatabase
import ru.sr.testtaskfooddelivery.rempte.StoreApi

const val BASE_URL = "https://run.mocky.io/v3/"

fun retrofitModule() = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    single {
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
    }

    single<StoreApi> { get<Retrofit>().create() }
}

fun roomModule() = module {

    single { StoreDatabase.getInstance(get()) }

    single { get<StoreDatabase>().createCartDao() }
}