package ru.sr.testtaskfooddelivery.feature_home.presentation.dish.delegate

import android.view.LayoutInflater
import ru.sr.adapter.adapterDelegate
import ru.sr.testtaskfooddelivery.feature_home.databinding.HomeItemDisheBinding
import ru.sr.testtaskfooddelivery.feature_home.databinding.HomeItemTagBinding
import ru.sr.testtaskfooddelivery.feature_home.presentation.dish.model.DishUiModel
import ru.sr.testtaskfooddelivery.feature_home.presentation.dish.model.Tag
import ru.sr.testtaskfooddelivery.feature_home.presentation.root.HomeDisplayItem
import ru.sr.testtaskfooddelivery.loadImage

fun dishDelegate(onClickItem: (DishUiModel) -> Unit) =
    adapterDelegate<HomeDisplayItem, DishUiModel, HomeItemDisheBinding>({ parent ->
        HomeItemDisheBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }) {
        binding.root.setOnClickListener { onClickItem(item) }
        bind {
            binding.productImage.loadImage(item.imageUrl)
            binding.productName.text = item.name
        }
    }

fun tagDelegate(onClickItem: (Tag) -> Unit) =
    adapterDelegate<HomeDisplayItem, Tag, HomeItemTagBinding>({ parent ->
        HomeItemTagBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }) {
        binding.root.setOnClickListener { onClickItem(item) }
        bind {
            binding.tag.text = item.dishTag.tag
            binding.tag.isSelected = item.isSelected
        }
    }