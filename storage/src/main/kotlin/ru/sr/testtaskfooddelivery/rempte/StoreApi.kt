package ru.sr.testtaskfooddelivery.rempte

import retrofit2.http.GET
import ru.sr.testtaskfooddelivery.rempte.dto.category.CategoriesDto
import ru.sr.testtaskfooddelivery.rempte.dto.dishe.DishesDto

interface StoreApi {

    @GET("058729bd-1402-4578-88de-265481fd7d54")
    suspend fun getAllCategory(): CategoriesDto

    @GET()
    suspend fun getAllDishes(): DishesDto

}