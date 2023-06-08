package ru.sr.testtaskfooddelivery.feature_home.domain.usecase.impl

import ru.sr.testtaskfooddelivery.feature_home.domain.repository.LocalHomeRepository
import ru.sr.testtaskfooddelivery.feature_home.domain.usecase.CartHomeContainItemUseCase

class CartHomeContainItemUseCaseImpl(
    private val repository: LocalHomeRepository,
) : CartHomeContainItemUseCase {
    override suspend fun isContain(id: Int): Boolean {
        return repository.itemContain(id)
    }
}