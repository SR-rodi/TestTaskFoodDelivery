package ru.sr.testtaskfooddelivery.feature_cart.presentation.model

data class CartItemUiModel(
    override val id: Int?,
    val imageUrl: String,
    val name: String,
    val price: Int,
    val weight: Int,
    override val counter: Int,
) : CartDisplayScreen