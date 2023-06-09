package ru.sr.testtaskfooddelivery.feature_home.data.repository

import ru.sr.testtaskfooddelivery.feature_home.domain.model.DishDomainModel
import ru.sr.testtaskfooddelivery.feature_home.domain.repository.LocalHomeRepository
import ru.sr.testtaskfooddelivery.feature_home.extension.toEntity
import ru.sr.testtaskfooddelivery.local.CartDao

class LocalHomeRepositoryImpl(private val dao: CartDao) : LocalHomeRepository {
    override suspend fun addItemToCart(item: DishDomainModel) {
        dao.insert(item.toEntity())
    }

    override suspend fun itemContain(id: Int): Boolean {
        return dao.getItemById(id) != null
    }
}