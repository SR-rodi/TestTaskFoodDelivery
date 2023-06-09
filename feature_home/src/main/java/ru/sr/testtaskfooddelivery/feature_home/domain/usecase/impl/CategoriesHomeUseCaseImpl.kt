package ru.sr.testtaskfooddelivery.feature_home.domain.usecase.impl

import ru.sr.testtaskfooddelivery.feature_home.domain.model.CategoryDomainModel
import ru.sr.testtaskfooddelivery.feature_home.domain.repository.RemoteStoreHomeRepository
import ru.sr.testtaskfooddelivery.feature_home.domain.usecase.CategoriesHomeUseCase

class CategoriesHomeUseCaseImpl(
    private val repository: RemoteStoreHomeRepository,
) : CategoriesHomeUseCase {
    override suspend fun getAll(): List<CategoryDomainModel> {
        return repository.getCategories()
    }
}