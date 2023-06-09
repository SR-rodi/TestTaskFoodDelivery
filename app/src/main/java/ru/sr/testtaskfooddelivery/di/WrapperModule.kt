package ru.sr.testtaskfooddelivery.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.sr.testtaskfooddelivery.wrapper.DispatcherWrapper
import ru.sr.testtaskfooddelivery.wrapper.DispatcherWrapperImpl

fun wrapperModule() = module {
    singleOf(::DispatcherWrapperImpl) { bind<DispatcherWrapper>() }
}