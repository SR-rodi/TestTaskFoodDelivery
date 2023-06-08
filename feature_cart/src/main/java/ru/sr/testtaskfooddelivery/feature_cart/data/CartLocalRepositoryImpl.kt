package ru.sr.testtaskfooddelivery.feature_cart.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.sr.testtaskfooddelivery.feature_cart.domain.model.CartItemDomainModel
import ru.sr.testtaskfooddelivery.feature_cart.domain.repository.CartLocalRepository
import ru.sr.testtaskfooddelivery.feature_cart.mapper.toDomain
import ru.sr.testtaskfooddelivery.feature_cart.mapper.toEntity
import ru.sr.testtaskfooddelivery.local.CartDao

class CartLocalRepositoryImpl(private val dao: CartDao) : CartLocalRepository {
    override fun getAllItems(): Flow<List<CartItemDomainModel>> {
        return dao.getAllItems().map { list ->
            list.map { entity -> entity.toDomain() }
        }
    }

    override suspend fun updateItem(item: CartItemDomainModel) {
        dao.update(item.toEntity())
    }

    override suspend fun deleteItem(item: CartItemDomainModel) {
        item.id ?: throw NullPointerException("id is null dao not Delete, check CartLocalRepositoryImpl")
        dao.delete(item.id)
    }
}