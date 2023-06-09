package ru.sr.testtaskfooddelivery.feature_cart.domain.usecase.impl

import ru.sr.testtaskfooddelivery.feature_cart.domain.model.CartItemDomainModel
import ru.sr.testtaskfooddelivery.feature_cart.domain.repository.CartLocalRepository
import ru.sr.testtaskfooddelivery.feature_cart.domain.usecase.CartCounterUseCase

class CartCounterUseCaseImpl(
    private val repository: CartLocalRepository,
) : CartCounterUseCase {
    override suspend fun update(item: CartItemDomainModel) {
        if (item.counter == 0) repository.deleteItem(item)
        else repository.updateItem(item)
    }
}