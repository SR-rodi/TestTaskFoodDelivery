package ru.sr.testtaskfooddelivery.feature_home.domain.usecase

import ru.sr.testtaskfooddelivery.feature_home.domain.model.DishDomainModel

interface CartHomeUseCase {
    suspend fun addToCart(item: DishDomainModel)
}

