package ru.sr.testtaskfooddelivery.feature_home.presentation.home.model

import ru.sr.testtaskfooddelivery.feature_home.presentation.root.HomeDisplayItem

class CategoryUiModel(
    override val id: Int,
    val image: String,
    val name: String,
) : HomeDisplayItem