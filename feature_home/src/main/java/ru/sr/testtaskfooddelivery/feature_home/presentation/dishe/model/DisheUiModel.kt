package ru.sr.testtaskfooddelivery.feature_home.presentation.dishe.model

class DisheUiModel(
    val description: String,
    val id: Int,
    val imageUrl: String,
    val name: String,
    val price: Int,
    val listTeg: List<String>,
    val weight: Int,
)