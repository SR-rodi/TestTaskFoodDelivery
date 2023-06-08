package ru.sr.testtaskfooddelivery.feature_cart.presentation.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import ru.sr.testtaskfooddelivery.feature_cart.presentation.model.CartDisplayScreen

class CartDiffUtil : DiffUtil.ItemCallback<CartDisplayScreen>() {
    override fun areItemsTheSame(oldItem: CartDisplayScreen, newItem: CartDisplayScreen): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: CartDisplayScreen,
        newItem: CartDisplayScreen,
    ): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: CartDisplayScreen, newItem: CartDisplayScreen): Any? {
        if (oldItem.counter != newItem.counter) return newItem.counter
        return super.getChangePayload(oldItem, newItem)
    }
}