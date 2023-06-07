package ru.sr.testtaskfooddelivery.rempte

import ru.sr.testtaskfooddelivery.rempte.dto.category.CategoriesDto
import ru.sr.testtaskfooddelivery.rempte.dto.dishe.DishesDto

interface StoreApi {

    suspend fun getAllCategory(): CategoriesDto

    suspend fun getAllDishes(): DishesDto

}