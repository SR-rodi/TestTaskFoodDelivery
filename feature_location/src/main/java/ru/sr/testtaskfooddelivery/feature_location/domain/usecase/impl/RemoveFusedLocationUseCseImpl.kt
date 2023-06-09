package ru.sr.testtaskfooddelivery.feature_location.domain.usecase.impl

import ru.sr.testtaskfooddelivery.feature_location.domain.repository.LocationRepository
import ru.sr.testtaskfooddelivery.feature_location.domain.usecase.RemoveFusedLocationUseCse

class RemoveFusedLocationUseCseImpl(
    private val repository: LocationRepository,
) : RemoveFusedLocationUseCse {

    override fun remove() {
        repository.removeFusedClient()
    }
}