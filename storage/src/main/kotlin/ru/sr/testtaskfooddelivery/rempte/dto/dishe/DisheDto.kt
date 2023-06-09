package ru.sr.testtaskfooddelivery.rempte.dto.dishe

import com.google.gson.annotations.SerializedName

class DisheDto(
    val description: String,
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String?,
    val name: String,
    val price: Int,
    @SerializedName("tegs")
    val listTeg: List<String>,
    val weight: Int,
)