package ru.sr.testtaskfooddelivery.feature_cart.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.sr.testtaskfooddelivery.base.BaseFragment
import ru.sr.testtaskfooddelivery.core_ui.R
import ru.sr.testtaskfooddelivery.feature_cart.databinding.FragmentCartBinding
import ru.sr.testtaskfooddelivery.feature_cart.presentation.adapter.CartAdapter
import ru.sr.testtaskfooddelivery.feature_cart.presentation.state.CartState
import ru.sr.testtaskfooddelivery.feature_cart.presentation.state.CounterButton

class CartFragment : BaseFragment<FragmentCartBinding>() {

    private val viewModel by viewModel<CartViewModel>()
    private val adapter by lazy { CartAdapter(::onCounterButtonClick) }

    override fun initBinding(inflater: LayoutInflater) = FragmentCartBinding.inflate(inflater)

    private fun onCounterButtonClick(counterButton: CounterButton) {
        viewModel.onCounterButtonClick(counterButton)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cartRecyclerView.adapter = adapter

        flowObserver(viewModel.cart) { items -> adapter.submitList(items) }
        flowObserver(viewModel.viewStates()) { state -> stateObserver(state) }
    }

    @SuppressLint("SetTextI18n")
    fun stateObserver(state: CartState) {
        binding.payButton.text =
            resources.getString(R.string.pay) +
                    " " + state.allPrice +
                    " " + resources.getString(R.string.сurrency)

    }
}