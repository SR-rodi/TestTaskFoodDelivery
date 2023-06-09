package ru.sr.testtaskfooddelivery.rempte.dto.category

import com.google.gson.annotations.SerializedName

class CategoriesDto(
    /** как то странно получается с буквой с, не на том языке она в Json*/
    @SerializedName("сategories")
    val categories: List<CategoryDto>,
)