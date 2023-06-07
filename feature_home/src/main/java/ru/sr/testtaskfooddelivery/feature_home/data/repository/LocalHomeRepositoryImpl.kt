package ru.sr.testtaskfooddelivery.feature_home.data.repository

import ru.sr.testtaskfooddelivery.feature_home.domain.model.DisheDomainModel
import ru.sr.testtaskfooddelivery.feature_home.domain.repository.LocalHomeRepository
import ru.sr.testtaskfooddelivery.feature_home.extension.toEntity
import ru.sr.testtaskfooddelivery.local.CartDao

class LocalHomeRepositoryImpl(private val dao: CartDao) : LocalHomeRepository {
    override suspend fun addItemToCart(item: DisheDomainModel) {
        dao.insert(item.toEntity())
    }
}