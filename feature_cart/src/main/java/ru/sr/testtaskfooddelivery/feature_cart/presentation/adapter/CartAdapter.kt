package ru.sr.testtaskfooddelivery.feature_cart.presentation.adapter

import ru.sr.adapter.ListDelegateAdapter
import ru.sr.testtaskfooddelivery.feature_cart.presentation.state.CounterButton
import ru.sr.testtaskfooddelivery.feature_cart.presentation.delegate.cartDelegate
import ru.sr.testtaskfooddelivery.feature_cart.presentation.model.CartDisplayScreen

class CartAdapter(
    onClick: (CounterButton) -> Unit,
) : ListDelegateAdapter<CartDisplayScreen>(CartDiffUtil()) {

    init {
        addDelegate(cartDelegate(onClick))
    }
}