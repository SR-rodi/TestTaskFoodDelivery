package ru.sr.testtaskfooddelivery.feature_home.presentation.dish.model

import ru.sr.testtaskfooddelivery.feature_home.data.DishTag
import ru.sr.testtaskfooddelivery.feature_home.presentation.root.HomeDisplayItem

data class Tag(
    val dishTag: DishTag,
    val isSelected: Boolean = false,
    override val id: Int = 0,
) : HomeDisplayItem