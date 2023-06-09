package ru.sr.testtaskfooddelivery.feature_location.presentation

import ru.sr.testtaskfooddelivery.feature_location.presentation.model.UserPositionUiModel

data class MainState(
    val userPosition: UserPositionUiModel = UserPositionUiModel(),
    val isNavigate: Boolean = false,
    val isErrorLocation:Boolean = false
)