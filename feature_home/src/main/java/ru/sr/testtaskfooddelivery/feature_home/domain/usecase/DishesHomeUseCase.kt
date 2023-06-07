package ru.sr.testtaskfooddelivery.feature_home.domain.usecase

import ru.sr.testtaskfooddelivery.feature_home.domain.model.DisheDomainModel

interface DishesHomeUseCase {
    suspend fun getAll(): List<DisheDomainModel>
}