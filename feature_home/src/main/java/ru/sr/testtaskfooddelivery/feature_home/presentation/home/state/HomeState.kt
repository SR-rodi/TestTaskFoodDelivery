package ru.sr.testtaskfooddelivery.feature_home.presentation.home.state

import ru.sr.testtaskfooddelivery.feature_home.presentation.home.model.CategoryUiModel

data class HomeState(
    val categories: List<CategoryUiModel> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
)