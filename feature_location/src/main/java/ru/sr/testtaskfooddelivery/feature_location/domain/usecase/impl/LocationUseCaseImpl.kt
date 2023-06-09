package ru.sr.testtaskfooddelivery.feature_location.domain.usecase.impl

import ru.sr.testtaskfooddelivery.feature_location.domain.model.UserPositionDomainModel
import ru.sr.testtaskfooddelivery.feature_location.domain.repository.LocationRepository
import ru.sr.testtaskfooddelivery.feature_location.domain.usecase.LocationUseCase

class LocationUseCaseImpl(private val repository: LocationRepository) : LocationUseCase {

    override fun getUserData(): UserPositionDomainModel {
        val location = repository.getUserLocation()
        val date = repository.getDate()
        return UserPositionDomainModel(location, date)
    }
}