package ru.sr.testtaskfooddelivery.base

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

abstract class BaseViewModel<State : Any>(initialState: State) : ViewModel() {

    private val _viewStates = MutableStateFlow(initialState)

    protected var viewState: State
        get() = _viewStates.value
        set(value) {
            _viewStates.value = value
        }

    fun viewStates() = _viewStates.asStateFlow()

    protected open fun onError(e: Exception) {
        Log.e("Kart", e.toString())
    }

    protected inline fun scopeLaunch(
        context: CoroutineContext = EmptyCoroutineContext,
        crossinline onError: (e: Exception) -> Unit = ::onError,
        crossinline job: suspend () -> Unit,
    ): Job {
        return viewModelScope.launch(context) {
            try {
                job()
            } catch (e: Exception) {
                onError(e)
            }
        }
    }
}