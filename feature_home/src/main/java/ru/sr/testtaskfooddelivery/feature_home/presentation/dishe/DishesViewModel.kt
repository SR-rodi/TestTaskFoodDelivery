package ru.sr.testtaskfooddelivery.feature_home.presentation.dishe

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.sr.testtaskfooddelivery.base.BaseViewModel
import ru.sr.testtaskfooddelivery.feature_home.data.DisheTag
import ru.sr.testtaskfooddelivery.feature_home.domain.usecase.DishesHomeUseCase
import ru.sr.testtaskfooddelivery.feature_home.extension.toUi
import ru.sr.testtaskfooddelivery.feature_home.presentation.dishe.model.DisheUiModel
import ru.sr.testtaskfooddelivery.feature_home.presentation.dishe.model.Tag
import ru.sr.testtaskfooddelivery.feature_home.presentation.dishe.state.DishesState
import ru.sr.testtaskfooddelivery.wrapper.DispatcherWrapper

class DishesViewModel(
    private val dispatcher: DispatcherWrapper,
    private val dishesUseCase: DishesHomeUseCase,
) : BaseViewModel<DishesState>(DishesState()) {

    private var allDishes = emptyList<DisheUiModel>()
    private var tagSelectorId = 0


    init {
        getAllDishes()
    }

    fun getAllDishes() = scopeLaunch(context = dispatcher.io, onError = ::onError) {
        viewState = viewState.copy(isLoading = true, isError = false)
        allDishes = dishesUseCase.getAll().map { domainModel -> domainModel.toUi() }
        viewState = viewState.copy(dishes = allDishes)
        viewState = viewState.copy(isLoading = false, tags = createTagsList())
    }

    fun getDishesByTag(tag: Tag) {
        val items = allDishes.filter { model -> model.listTeg.contains(tag.disheTag.tag) }
        viewState = viewState.copy(dishes = items, tags = selectorTags(tag.id))
    }

    private fun createTagsList(): List<Tag> {
        val tags = DisheTag.values().map { disheTag -> Tag(disheTag, id = disheTag.ordinal) }
            .toMutableList()
        tags[tagSelectorId] = tags[tagSelectorId].copy(isSelected = true)
        return tags
    }

    private fun selectorTags(newSelectorId: Int): List<Tag> {
        val tags = viewState.tags.toMutableList()
        tags[tagSelectorId] = tags[tagSelectorId].copy(isSelected = false)
        tags[newSelectorId] = tags[newSelectorId].copy(isSelected = true)
        tagSelectorId = newSelectorId
        return tags
    }

    private fun onError(e: Exception) {
        Log.e("Kart", e.toString())
        viewState = viewState.copy(isLoading = false, isError = true)
    }
}

