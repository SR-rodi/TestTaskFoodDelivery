package ru.sr.testtaskfooddelivery.feature_location.mapper

import ru.sr.testtaskfooddelivery.feature_location.domain.model.UserPositionDomainModel
import ru.sr.testtaskfooddelivery.feature_location.presentation.model.UserPositionUiModel

fun UserPositionDomainModel.toUi() = UserPositionUiModel(cityName, date)