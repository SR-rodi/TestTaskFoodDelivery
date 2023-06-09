package ru.sr.testtaskfooddelivery.feature_home.data.repository

import ru.sr.testtaskfooddelivery.feature_home.domain.model.CategoryDomainModel
import ru.sr.testtaskfooddelivery.feature_home.domain.model.DisheDomainModel
import ru.sr.testtaskfooddelivery.feature_home.domain.repository.RemoteStoreHomeRepository
import ru.sr.testtaskfooddelivery.feature_home.extension.toDomain
import ru.sr.testtaskfooddelivery.rempte.StoreApi

class RemoteStoreHomeRepositoryImpl(private val api: StoreApi) : RemoteStoreHomeRepository {

    override suspend fun getCategories(): List<CategoryDomainModel> {
        return api.getAllCategory().toDomain()
    }

    override suspend fun getDishes(): List<DisheDomainModel> {
        return api.getAllDishes().toDomain()
    }
}