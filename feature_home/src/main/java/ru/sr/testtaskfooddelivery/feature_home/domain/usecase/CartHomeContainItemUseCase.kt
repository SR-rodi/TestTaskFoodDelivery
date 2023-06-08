package ru.sr.testtaskfooddelivery.feature_home.domain.usecase

interface CartHomeContainItemUseCase {
    suspend fun isContain(id: Int): Boolean
}