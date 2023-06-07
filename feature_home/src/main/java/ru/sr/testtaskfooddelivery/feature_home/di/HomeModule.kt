package ru.sr.testtaskfooddelivery.feature_home.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.sr.testtaskfooddelivery.feature_home.data.repository.LocalHomeRepositoryImpl
import ru.sr.testtaskfooddelivery.feature_home.data.repository.RemoteStoreHomeRepositoryImpl
import ru.sr.testtaskfooddelivery.feature_home.domain.repository.LocalHomeRepository
import ru.sr.testtaskfooddelivery.feature_home.domain.repository.RemoteStoreHomeRepository
import ru.sr.testtaskfooddelivery.feature_home.domain.usecase.CartHomeUseCase
import ru.sr.testtaskfooddelivery.feature_home.domain.usecase.CategoriesHomeUseCase
import ru.sr.testtaskfooddelivery.feature_home.domain.usecase.DishesHomeUseCase
import ru.sr.testtaskfooddelivery.feature_home.domain.usecase.impl.CartHomeUseCaseImpl
import ru.sr.testtaskfooddelivery.feature_home.domain.usecase.impl.CategoriesHomeUseCaseImpl
import ru.sr.testtaskfooddelivery.feature_home.domain.usecase.impl.DishesHomeUseCaseImpl
import ru.sr.testtaskfooddelivery.feature_home.presentation.dishe.DishesViewModel
import ru.sr.testtaskfooddelivery.feature_home.presentation.home.HomeViewModel
import ru.sr.testtaskfooddelivery.feature_home.presentation.product.ProductViewModel

fun homeModule() = listOf(repositoryModule(), useCaseModule(), homeViewModelModule())

internal fun repositoryModule() = module {
    singleOf(::RemoteStoreHomeRepositoryImpl) { bind<RemoteStoreHomeRepository>() }
    singleOf(::LocalHomeRepositoryImpl) { bind<LocalHomeRepository>() }
}

internal fun useCaseModule() = module {
    singleOf(::DishesHomeUseCaseImpl) { bind<DishesHomeUseCase>() }
    singleOf(::CategoriesHomeUseCaseImpl) { bind<CategoriesHomeUseCase>() }
    singleOf(::CartHomeUseCaseImpl) { bind<CartHomeUseCase>() }
}

internal fun homeViewModelModule() = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::DishesViewModel)
    viewModelOf(::ProductViewModel)
}
