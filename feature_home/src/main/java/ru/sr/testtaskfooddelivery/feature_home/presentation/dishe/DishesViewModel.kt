package ru.sr.testtaskfooddelivery.feature_home.presentation.dishe

import ru.sr.testtaskfooddelivery.base.BaseViewModel
import ru.sr.testtaskfooddelivery.feature_home.data.DisheTag
import ru.sr.testtaskfooddelivery.feature_home.domain.usecase.DishesHomeUseCase
import ru.sr.testtaskfooddelivery.feature_home.extension.toUi
import ru.sr.testtaskfooddelivery.feature_home.presentation.dishe.model.DisheUiModel
import ru.sr.testtaskfooddelivery.feature_home.presentation.dishe.state.DishesState
import ru.sr.testtaskfooddelivery.wrapper.DispatcherWrapper

class DishesViewModel(
    private val dispatcher: DispatcherWrapper,
    private val dishesUseCase: DishesHomeUseCase,
) : BaseViewModel<DishesState>(DishesState()) {

    private var allDishes = emptyList<DisheUiModel>()


    init {
        getAllDishes()
    }

    private fun getAllDishes() = scopeLaunch(dispatcher.io) {
        viewState = viewState.copy(isLoading = true, isError = false)
        allDishes = dishesUseCase.getAll().map { domainModel -> domainModel.toUi() }
        viewState = viewState.copy(isLoading = false)
    }

    fun getDishesByTag(disheTag: DisheTag) {
        val items = allDishes.filter { model -> model.listTeg.contains(disheTag.tag) }
        viewState = viewState.copy(dishes = items)
    }


     fun onError(e: Exception) {

        viewState = viewState.copy(isLoading = false, isError = true)
    }
}

