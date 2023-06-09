package ru.sr.testtaskfooddelivery.feature_cart.mapper

import ru.sr.testtaskfooddelivery.feature_cart.domain.model.CartItemDomainModel
import ru.sr.testtaskfooddelivery.feature_cart.presentation.model.CartItemUiModel
import ru.sr.testtaskfooddelivery.local.CartItemEntity

fun CartItemEntity.toDomain(): CartItemDomainModel {
    return CartItemDomainModel(id, imageUrl, name, price, weight, counter)
}

fun CartItemDomainModel.toEntity(): CartItemEntity {
    return CartItemEntity(id, imageUrl, name, price, weight, counter)
}

fun CartItemDomainModel.toUi(): CartItemUiModel {
    return CartItemUiModel(id, imageUrl, name, price, weight, counter)
}

fun CartItemUiModel.toDomain(): CartItemDomainModel {
    return CartItemDomainModel(id, imageUrl, name, price, weight, counter)
}