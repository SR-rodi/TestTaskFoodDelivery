package ru.sr.testtaskfooddelivery.feature_home.domain.repository

import ru.sr.testtaskfooddelivery.feature_home.domain.model.CategoryDomainModel
import ru.sr.testtaskfooddelivery.feature_home.domain.model.DisheDomainModel

interface RemoteStoreHomeRepository {
    suspend fun getCategories(): List<CategoryDomainModel>
    suspend fun getDishes(): List<DisheDomainModel>
}