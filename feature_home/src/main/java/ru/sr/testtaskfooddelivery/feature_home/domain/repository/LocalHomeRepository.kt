package ru.sr.testtaskfooddelivery.feature_home.domain.repository

import ru.sr.testtaskfooddelivery.feature_home.domain.model.DishDomainModel

interface LocalHomeRepository {
    suspend fun addItemToCart(item: DishDomainModel)
    suspend fun itemContain(id: Int): Boolean
}