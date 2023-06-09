package ru.sr.testtaskfooddelivery.feature_home.extension

import ru.sr.testtaskfooddelivery.feature_home.domain.model.CategoryDomainModel
import ru.sr.testtaskfooddelivery.feature_home.domain.model.DishDomainModel
import ru.sr.testtaskfooddelivery.feature_home.presentation.dish.model.DishUiModel
import ru.sr.testtaskfooddelivery.feature_home.presentation.home.model.CategoryUiModel
import ru.sr.testtaskfooddelivery.local.CartItemEntity
import ru.sr.testtaskfooddelivery.rempte.dto.category.CategoriesDto
import ru.sr.testtaskfooddelivery.rempte.dto.category.CategoryDto
import ru.sr.testtaskfooddelivery.rempte.dto.dishe.DisheDto
import ru.sr.testtaskfooddelivery.rempte.dto.dishe.DishesDto

fun CategoriesDto.toDomain(): List<CategoryDomainModel> {
    return categories.map { categoryDto -> categoryDto.toDomain() }
}

fun CategoryDto.toDomain(): CategoryDomainModel {
    return CategoryDomainModel(id, image, name)
}

fun DisheDto.toDomain(): DishDomainModel {
    /** в ответе от сервера item под 4 id приходит с отсутствующим полем imageUrl а в поле  description
     * приходит ссылка на картинку*/
    return DishDomainModel(description, id, imageUrl ?: description, name, price, listTeg, weight)
}

fun DishesDto.toDomain(): List<DishDomainModel> {
    return dishes.map { disheDto -> disheDto.toDomain() }
}

fun CategoryDomainModel.toUi(): CategoryUiModel {
    return CategoryUiModel(id, image, name)
}

fun DishDomainModel.toUi(): DishUiModel {
    return DishUiModel(description, id, image, name, price, listTeg, weight)
}

fun DishDomainModel.toEntity(): CartItemEntity {
    return CartItemEntity(id, image, name, price, weight, 1)
}

fun DishUiModel.toDomain(): DishDomainModel {
    return DishDomainModel(description, id, imageUrl, name, price, listTeg, weight)
}
