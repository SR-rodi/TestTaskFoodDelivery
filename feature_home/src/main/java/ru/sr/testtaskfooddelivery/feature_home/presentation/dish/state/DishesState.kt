package ru.sr.testtaskfooddelivery.feature_home.presentation.dish.state

import ru.sr.testtaskfooddelivery.feature_home.presentation.dish.model.Tag
import ru.sr.testtaskfooddelivery.feature_home.presentation.dish.model.DishUiModel

data class DishesState(
    val dishes: List<DishUiModel> = emptyList(),
    val tags: List<Tag> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
)