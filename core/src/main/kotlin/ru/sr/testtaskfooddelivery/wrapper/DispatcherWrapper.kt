package ru.sr.testtaskfooddelivery.wrapper

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface DispatcherWrapper {
    val io: CoroutineDispatcher
}

class DispatcherWrapperImpl : DispatcherWrapper {
    override val io: CoroutineDispatcher
        get() = Dispatchers.IO

}