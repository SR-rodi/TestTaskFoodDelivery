package ru.sr.testtaskfooddelivery.wrapper

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherWrapper {
    val io: CoroutineDispatcher
}