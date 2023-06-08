package ru.sr.testtaskfooddelivery.feature_home.presentation.dishe.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import ru.sr.testtaskfooddelivery.feature_home.presentation.root.HomeDisplayItem

@Parcelize
class DisheUiModel(
    val description: String,
    override val id: Int,
    val imageUrl: String,
    val name: String,
    val price: Int,
    val listTeg: List<String>,
    val weight: Int,
) : HomeDisplayItem, Parcelable