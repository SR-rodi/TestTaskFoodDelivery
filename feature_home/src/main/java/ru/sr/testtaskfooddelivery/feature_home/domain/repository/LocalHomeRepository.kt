package ru.sr.testtaskfooddelivery.feature_home.domain.repository

import ru.sr.testtaskfooddelivery.feature_home.domain.model.DisheDomainModel

interface LocalHomeRepository {
    suspend fun addItemToCart(item: DisheDomainModel)
}