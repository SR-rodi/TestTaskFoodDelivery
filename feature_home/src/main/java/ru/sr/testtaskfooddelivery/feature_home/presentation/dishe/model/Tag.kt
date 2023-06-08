package ru.sr.testtaskfooddelivery.feature_home.presentation.dishe.model

import ru.sr.testtaskfooddelivery.feature_home.data.DisheTag
import ru.sr.testtaskfooddelivery.feature_home.presentation.root.HomeDisplayItem

data class Tag(
    val disheTag: DisheTag,
    val isSelected: Boolean = false,
    override val id: Int = 0,
) : HomeDisplayItem