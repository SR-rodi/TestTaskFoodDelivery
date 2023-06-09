package ru.sr.testtaskfooddelivery.feature_location.domain.usecase

import ru.sr.testtaskfooddelivery.feature_location.domain.model.UserPositionDomainModel

interface LocationUseCase {

    fun getUserData(): UserPositionDomainModel
}

