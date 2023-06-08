package ru.sr.testtaskfooddelivery.feature_home.presentation.home.delegate

import android.view.LayoutInflater
import ru.sr.adapter.adapterDelegate
import ru.sr.testtaskfooddelivery.feature_home.databinding.HomeItemCategoryBinding
import ru.sr.testtaskfooddelivery.feature_home.presentation.root.HomeDisplayItem
import ru.sr.testtaskfooddelivery.feature_home.presentation.home.model.CategoryUiModel
import ru.sr.testtaskfooddelivery.loadImage

fun categoryDelegate(onClickItem: (String) -> Unit) =
    adapterDelegate<HomeDisplayItem, CategoryUiModel, HomeItemCategoryBinding>({ parent ->
        HomeItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }) {
        binding.root.setOnClickListener { onClickItem(item.name) }
        bind {
            binding.image.loadImage(item.image)
            binding.title.text = item.name
        }
    }

