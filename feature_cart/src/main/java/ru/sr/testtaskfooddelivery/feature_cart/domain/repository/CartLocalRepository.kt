package ru.sr.testtaskfooddelivery.feature_cart.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.sr.testtaskfooddelivery.feature_cart.domain.model.CartItemDomainModel

interface CartLocalRepository {

    fun getAllItems(): Flow<List<CartItemDomainModel>>

    suspend fun updateItem(item: CartItemDomainModel)

    suspend fun deleteItem(item: CartItemDomainModel)
}

