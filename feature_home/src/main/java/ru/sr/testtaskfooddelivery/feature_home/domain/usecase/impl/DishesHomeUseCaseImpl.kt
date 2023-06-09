package ru.sr.testtaskfooddelivery.feature_home.domain.usecase.impl

import ru.sr.testtaskfooddelivery.feature_home.domain.model.DisheDomainModel
import ru.sr.testtaskfooddelivery.feature_home.domain.repository.RemoteStoreHomeRepository
import ru.sr.testtaskfooddelivery.feature_home.domain.usecase.DishesHomeUseCase

class DishesHomeUseCaseImpl(
    private val repository: RemoteStoreHomeRepository,
) : DishesHomeUseCase {
    override suspend fun getAll(): List<DisheDomainModel> {
        return repository.getDishes()
    }
}