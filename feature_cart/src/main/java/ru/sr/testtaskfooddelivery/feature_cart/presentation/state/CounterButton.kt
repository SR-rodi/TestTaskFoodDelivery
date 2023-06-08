package ru.sr.testtaskfooddelivery.feature_cart.presentation.state

import ru.sr.testtaskfooddelivery.feature_cart.presentation.model.CartItemUiModel

enum class CounterButton(var cartItem: CartItemUiModel?= null) {
    PLUS, MINUS
}