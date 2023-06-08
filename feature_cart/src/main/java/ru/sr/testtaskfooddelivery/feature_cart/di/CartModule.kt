package ru.sr.testtaskfooddelivery.feature_cart.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.sr.testtaskfooddelivery.feature_cart.presentation.CartViewModel
import ru.sr.testtaskfooddelivery.feature_cart.data.CartLocalRepositoryImpl
import ru.sr.testtaskfooddelivery.feature_cart.domain.repository.CartLocalRepository
import ru.sr.testtaskfooddelivery.feature_cart.domain.usecase.CartAllItemsUseCase
import ru.sr.testtaskfooddelivery.feature_cart.domain.usecase.CartCounterUseCase
import ru.sr.testtaskfooddelivery.feature_cart.domain.usecase.impl.CartAllItemsUseCaseImpl
import ru.sr.testtaskfooddelivery.feature_cart.domain.usecase.impl.CartCounterUseCaseImpl

fun cartModule() = listOf(cartRepositoryModule(),cartUseCaseModule(),cartViewModelModule())

fun cartRepositoryModule() = module {
    singleOf(::CartLocalRepositoryImpl){bind<CartLocalRepository>()}
}

fun cartUseCaseModule() = module {
    singleOf(::CartAllItemsUseCaseImpl){bind<CartAllItemsUseCase>()}
    singleOf(::CartCounterUseCaseImpl){bind<CartCounterUseCase>()}
}

fun cartViewModelModule() = module {
    viewModelOf(::CartViewModel)
}