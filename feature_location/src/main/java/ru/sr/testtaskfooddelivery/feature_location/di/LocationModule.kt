package ru.sr.testtaskfooddelivery.feature_location.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.sr.testtaskfooddelivery.feature_location.data.DateProviderImpl
import ru.sr.testtaskfooddelivery.feature_location.data.FusedClientImpl
import ru.sr.testtaskfooddelivery.feature_location.data.GeocoderClientImpl
import ru.sr.testtaskfooddelivery.feature_location.data.LocationDateWrapperImpl
import ru.sr.testtaskfooddelivery.feature_location.data.LocationRepositoryImpl
import ru.sr.testtaskfooddelivery.feature_location.data.UserLocationCallBack
import ru.sr.testtaskfooddelivery.feature_location.domain.wrapper.DateProvider
import ru.sr.testtaskfooddelivery.feature_location.domain.wrapper.FusedClient
import ru.sr.testtaskfooddelivery.feature_location.domain.wrapper.GeocoderClient
import ru.sr.testtaskfooddelivery.feature_location.domain.wrapper.LocationDateWrapper
import ru.sr.testtaskfooddelivery.feature_location.domain.repository.LocationRepository
import ru.sr.testtaskfooddelivery.feature_location.domain.usecase.LocationUseCase
import ru.sr.testtaskfooddelivery.feature_location.domain.usecase.impl.LocationUseCaseImpl
import ru.sr.testtaskfooddelivery.feature_location.presentation.LocationViewModel

fun locationModule() =
    listOf(
        locationRepositoryModule(),
        locationWrapperModule(),
        locationViewModelModule(),
        locationUseCaseModule()
    )

internal fun locationRepositoryModule() = module {

    singleOf(::LocationRepositoryImpl) { bind<LocationRepository>() }
}

internal fun locationWrapperModule() = module {
    singleOf(::UserLocationCallBack)
    singleOf(::GeocoderClientImpl) { bind<GeocoderClient>() }
    singleOf(::FusedClientImpl) { bind<FusedClient>() }
    singleOf(::LocationDateWrapperImpl) { bind<LocationDateWrapper>() }
    singleOf(::DateProviderImpl) { bind<DateProvider>() }
}

internal fun locationUseCaseModule() = module {
    singleOf(::LocationUseCaseImpl) { bind<LocationUseCase>() }
}

internal fun locationViewModelModule() = module {
    viewModelOf(::LocationViewModel)
}