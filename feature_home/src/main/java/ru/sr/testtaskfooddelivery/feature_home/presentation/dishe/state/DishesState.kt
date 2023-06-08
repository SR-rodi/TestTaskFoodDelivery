package ru.sr.testtaskfooddelivery.feature_home.presentation.dishe.state

import ru.sr.testtaskfooddelivery.feature_home.presentation.dishe.model.Tag
import ru.sr.testtaskfooddelivery.feature_home.presentation.dishe.model.DisheUiModel

data class DishesState(
    val dishes: List<DisheUiModel> = emptyList(),
    val tags: List<Tag> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
)