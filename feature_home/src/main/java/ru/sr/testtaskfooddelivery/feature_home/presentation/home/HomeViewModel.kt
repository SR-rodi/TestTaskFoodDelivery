package ru.sr.testtaskfooddelivery.feature_home.presentation.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.sr.testtaskfooddelivery.base.BaseViewModel
import ru.sr.testtaskfooddelivery.feature_home.presentation.home.state.HomeState
import ru.sr.testtaskfooddelivery.feature_home.domain.usecase.CategoriesHomeUseCase
import ru.sr.testtaskfooddelivery.feature_home.extension.toUi
import ru.sr.testtaskfooddelivery.wrapper.DispatcherWrapper

class HomeViewModel(
    private val categoriesUseCase: CategoriesHomeUseCase,
    private val dispatcher: DispatcherWrapper,
) : BaseViewModel<HomeState>(HomeState()) {

    init {
        getCategories()
    }

    fun getCategories() = scopeLaunch(
        context = dispatcher.io, onError = ::onError
    ) {
        viewState = viewState.copy(isLoading = true, isError = false)
        val items = categoriesUseCase.getAll().map { domain -> domain.toUi() }
        viewState = viewState.copy(isLoading = false, categories = items)
    }

    private fun onError(e: Exception) {
        viewState = viewState.copy(isLoading = false, isError = true)
        Log.e("Kart", e.toString())

    }
}

