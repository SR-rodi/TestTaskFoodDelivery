package ru.sr.testtaskfooddelivery.feature_cart.presentation.delegate

import android.view.LayoutInflater
import ru.sr.adapter.adapterDelegate
import ru.sr.testtaskfooddelivery.feature_cart.databinding.CartItemBinding
import ru.sr.testtaskfooddelivery.feature_cart.presentation.model.CartDisplayScreen
import ru.sr.testtaskfooddelivery.feature_cart.presentation.model.CartItemUiModel
import ru.sr.testtaskfooddelivery.feature_cart.presentation.state.CounterButton
import ru.sr.testtaskfooddelivery.loadImage

fun cartDelegate(onClick: (CounterButton) -> Unit) =
    adapterDelegate<CartDisplayScreen, CartItemUiModel, CartItemBinding>({ parent ->
        CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }) {
        binding.plus.setOnClickListener {
            onClick(CounterButton.PLUS.apply { cartItem = item })
        }
        binding.minus.setOnClickListener {
            onClick(CounterButton.MINUS.apply { cartItem = item })
        }
        bind {
            binding.apply {
                productScreen.loadImage(item.imageUrl)
                productCounter.text = item.counter.toString()
                productPrice.text = item.price.toString()
                productWeight.text = item.weight.toString()
                productName.text = item.name
            }
        }

        bindForPayloads { payloads ->
            val counter = payloads.last() as Int
            binding.productCounter.text = counter.toString()
        }
    }