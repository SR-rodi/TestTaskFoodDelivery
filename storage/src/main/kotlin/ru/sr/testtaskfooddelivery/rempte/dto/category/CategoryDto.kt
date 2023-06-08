package ru.sr.testtaskfooddelivery.rempte.dto.category

import com.google.gson.annotations.SerializedName

data class CategoryDto(
    val id: Int,
    @SerializedName("image_url")
    val image: String,
    val name: String
)