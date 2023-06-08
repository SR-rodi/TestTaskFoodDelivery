package ru.sr.testtaskfooddelivery.feature_cart.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import ru.sr.testtaskfooddelivery.feature_cart.domain.model.CartItemDomainModel
import ru.sr.testtaskfooddelivery.feature_cart.domain.repository.CartLocalRepository
import ru.sr.testtaskfooddelivery.feature_cart.domain.usecase.CartAllItemsUseCase

class CartAllItemsUseCaseImpl(
    private val repository: CartLocalRepository,
) : CartAllItemsUseCase {
    override fun get():Flow<List<CartItemDomainModel>> {
        return repository.getAllItems()
    }
}