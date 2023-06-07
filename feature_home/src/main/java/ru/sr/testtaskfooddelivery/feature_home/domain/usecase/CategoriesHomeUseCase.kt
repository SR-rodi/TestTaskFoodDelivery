package ru.sr.testtaskfooddelivery.feature_home.domain.usecase

import ru.sr.testtaskfooddelivery.feature_home.domain.model.CategoryDomainModel

interface CategoriesHomeUseCase {
    suspend fun getAll(): List<CategoryDomainModel>
}