package ru.sr.testtaskfooddelivery.feature_cart.presentation

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import ru.sr.testtaskfooddelivery.base.BaseViewModel
import ru.sr.testtaskfooddelivery.feature_cart.domain.model.CartItemDomainModel
import ru.sr.testtaskfooddelivery.feature_cart.domain.usecase.CartAllItemsUseCase
import ru.sr.testtaskfooddelivery.feature_cart.domain.usecase.CartCounterUseCase
import ru.sr.testtaskfooddelivery.feature_cart.mapper.toDomain
import ru.sr.testtaskfooddelivery.feature_cart.mapper.toUi
import ru.sr.testtaskfooddelivery.feature_cart.presentation.state.CounterButton
import ru.sr.testtaskfooddelivery.feature_cart.presentation.model.CartItemUiModel
import ru.sr.testtaskfooddelivery.feature_cart.presentation.state.CartState
import ru.sr.testtaskfooddelivery.wrapper.DispatcherWrapper

class CartViewModel(
    cartAllItemsUseCase: CartAllItemsUseCase,
    private val cartCounterUseCase: CartCounterUseCase,
    private val dispatcher: DispatcherWrapper,
) : BaseViewModel<CartState>(CartState()) {

    val cart = cartAllItemsUseCase.get().map { items -> mapUi(items) }

    fun onCounterButtonClick(counterButton: CounterButton) {
        val item = counterButton.cartItem ?: return
        viewModelScope.launch(context = dispatcher.io) {
            val newCounter = when (counterButton) {
                CounterButton.PLUS -> item.counter + 1
                CounterButton.MINUS -> item.counter - 1
            }
            cartCounterUseCase.update(item.copy(counter = newCounter).toDomain())
        }
    }

    private fun mapUi(items: List<CartItemDomainModel>): List<CartItemUiModel> {
        var cartPrice = 0
        val newItems = items.map { domainModel ->
            cartPrice += domainModel.price * domainModel.counter
            domainModel.toUi()
        }
        viewState = viewState.copy(allPrice = cartPrice)
        return newItems
    }
}