package ru.sr.testtaskfooddelivery.feature_cart.domain.usecase

import kotlinx.coroutines.flow.Flow
import ru.sr.testtaskfooddelivery.feature_cart.domain.model.CartItemDomainModel

interface CartAllItemsUseCase {
    fun get(): Flow<List<CartItemDomainModel>>
}