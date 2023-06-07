package ru.sr.testtaskfooddelivery.rempte.dto.category

import com.google.gson.annotations.SerializedName

class CategoriesDto(
    @SerializedName("сategories")
    val categories: List<CategoryDto>
)