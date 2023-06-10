package ru.sr.testtaskfooddelivery.feature_home.presentation.product

import ru.sr.testtaskfooddelivery.base.BaseViewModel
import ru.sr.testtaskfooddelivery.feature_home.domain.usecase.CartHomeContainItemUseCase
import ru.sr.testtaskfooddelivery.feature_home.domain.usecase.CartHomeUseCase
import ru.sr.testtaskfooddelivery.feature_home.extension.toDomain
import ru.sr.testtaskfooddelivery.feature_home.presentation.dishe.model.DisheUiModel
import ru.sr.testtaskfooddelivery.feature_home.presentation.product.state.ProductState
import ru.sr.testtaskfooddelivery.wrapper.DispatcherWrapper

class ProductViewModel(
    private val addUseCase: CartHomeUseCase,
    private val containItemUseCase: CartHomeContainItemUseCase,
    private val dispatcher: DispatcherWrapper,
) : BaseViewModel<ProductState>(ProductState()) {

    fun addProductToCart(item: DisheUiModel) = scopeLaunch(context = dispatcher.io) {
        viewState = viewState.copy(isLoading = true)
        addUseCase.addToCart(item.toDomain())
        viewState = viewState.copy(isLoading = false, isContain = true)
    }

    fun checkItemInCart(id: Int) = scopeLaunch(context = dispatcher.io) {
        viewState = viewState.copy(isContain = containItemUseCase.isContain(id))
    }
}

