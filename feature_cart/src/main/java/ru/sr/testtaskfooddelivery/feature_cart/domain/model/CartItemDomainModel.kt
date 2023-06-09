package ru.sr.testtaskfooddelivery.feature_cart.domain.model

data class CartItemDomainModel(
    val id: Int?,
    val imageUrl: String,
    val name: String,
    val price: Int,
    val weight: Int,
    val counter:Int
)