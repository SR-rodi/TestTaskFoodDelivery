package ru.sr.testtaskfooddelivery.wrapper

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class DispatcherWrapperImpl : DispatcherWrapper {
    override val io: CoroutineDispatcher
        get() = Dispatchers.IO
}