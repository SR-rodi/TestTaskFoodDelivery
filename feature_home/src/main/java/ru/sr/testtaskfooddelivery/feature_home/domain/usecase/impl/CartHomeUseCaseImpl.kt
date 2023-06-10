package ru.sr.testtaskfooddelivery.feature_home.domain.usecase.impl

import ru.sr.testtaskfooddelivery.feature_home.domain.model.DishDomainModel
import ru.sr.testtaskfooddelivery.feature_home.domain.repository.LocalHomeRepository
import ru.sr.testtaskfooddelivery.feature_home.domain.usecase.CartHomeUseCase

class CartHomeUseCaseImpl(private val repository: LocalHomeRepository) : CartHomeUseCase {
    override suspend fun addToCart(item: DishDomainModel) {
        repository.addItemToCart(item)
    }
}