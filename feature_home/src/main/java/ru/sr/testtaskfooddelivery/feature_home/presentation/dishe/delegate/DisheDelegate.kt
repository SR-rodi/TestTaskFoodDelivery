package ru.sr.testtaskfooddelivery.feature_home.presentation.dishe.delegate

import android.view.LayoutInflater
import ru.sr.adapter.adapterDelegate
import ru.sr.testtaskfooddelivery.feature_home.databinding.HomeItemDisheBinding
import ru.sr.testtaskfooddelivery.feature_home.databinding.HomeItemTagBinding
import ru.sr.testtaskfooddelivery.feature_home.presentation.dishe.model.DisheUiModel
import ru.sr.testtaskfooddelivery.feature_home.presentation.dishe.model.Tag
import ru.sr.testtaskfooddelivery.feature_home.presentation.root.HomeDisplayItem
import ru.sr.testtaskfooddelivery.loadImage

fun disheDelegate(onClickItem: (DisheUiModel) -> Unit) =
    adapterDelegate<HomeDisplayItem, DisheUiModel, HomeItemDisheBinding>({ parent ->
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
            binding.tag.text = item.disheTag.tag
            binding.tag.isSelected = item.isSelected
        }
    }

