package ru.sr.testtaskfooddelivery.feature_home.presentation.dishe.model

import ru.sr.testtaskfooddelivery.feature_home.presentation.root.HomeDisplayItem

class DisheUiModel(
    val description: String,
    override val id: Int,
    val imageUrl: String,
    val name: String,
    val price: Int,
    val listTeg: List<String>,
    val weight: Int,
): HomeDisplayItem