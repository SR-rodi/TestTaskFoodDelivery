package ru.sr.testtaskfooddelivery.rempte.dto.dishe

import com.google.gson.annotations.SerializedName

data class DisheDto(
    val description: String,
    val id: Int,
    val image_url: String,
    val name: String,
    val price: Int,
    @SerializedName("tegs")
    val listTeg: List<String>,
    val weight: Int
)