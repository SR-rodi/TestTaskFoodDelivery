package ru.sr.testtaskfooddelivery.rempte

import retrofit2.http.GET
import ru.sr.testtaskfooddelivery.rempte.dto.category.CategoriesDto
import ru.sr.testtaskfooddelivery.rempte.dto.dishe.DishesDto

interface StoreApi {

    @GET(CATEGORY)
    suspend fun getAllCategory(): CategoriesDto

    @GET(DISHES)
    suspend fun getAllDishes(): DishesDto

    private companion object{
        const val CATEGORY = "058729bd-1402-4578-88de-265481fd7d54"
        const val DISHES = "c7a508f2-a904-498a-8539-09d96785446e"
    }
}