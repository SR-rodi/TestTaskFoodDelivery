package ru.sr.testtaskfooddelivery.feature_home.domain.model

class DisheDomainModel (
    val description: String,
    val id: Int,
    val image: String,
    val name: String,
    val price: Int,
    val listTeg: List<String>,
    val weight: Int
)