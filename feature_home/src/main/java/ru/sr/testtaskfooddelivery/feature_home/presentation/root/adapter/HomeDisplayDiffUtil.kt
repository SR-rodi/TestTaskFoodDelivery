package ru.sr.testtaskfooddelivery.feature_home.presentation.root.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import ru.sr.testtaskfooddelivery.feature_home.presentation.root.HomeDisplayItem

class HomeDisplayDiffUtil : DiffUtil.ItemCallback<HomeDisplayItem>() {
    override fun areItemsTheSame(oldItem: HomeDisplayItem, newItem: HomeDisplayItem) =
        oldItem.id == newItem.id

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: HomeDisplayItem, newItem: HomeDisplayItem) =
        oldItem == newItem
}