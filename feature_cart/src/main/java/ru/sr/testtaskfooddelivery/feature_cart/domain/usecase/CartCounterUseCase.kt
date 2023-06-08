package ru.sr.testtaskfooddelivery.feature_cart.domain.usecase

import ru.sr.testtaskfooddelivery.feature_cart.domain.model.CartItemDomainModel

interface CartCounterUseCase {
    suspend fun update(item: CartItemDomainModel)
}