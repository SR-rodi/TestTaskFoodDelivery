package ru.sr.testtaskfooddelivery.feature_home.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.sr.testtaskfooddelivery.base.BaseFragment
import ru.sr.testtaskfooddelivery.feature_home.R
import ru.sr.testtaskfooddelivery.feature_home.databinding.FragmentHomeBinding
import ru.sr.testtaskfooddelivery.feature_home.presentation.root.adapter.HomeAdapter
import ru.sr.testtaskfooddelivery.feature_home.presentation.home.state.HomeState

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val adapter by lazy { HomeAdapter(onClickCategory = ::onClickItem) }
    private val viewModel by viewModel<HomeViewModel>()

    override fun initBinding(inflater: LayoutInflater) = FragmentHomeBinding.inflate(inflater)

    private fun onClickItem(item: String) {
        findNavController().navigate(R.id.action_blankFragment_to_categoryFragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeRecyclerView.adapter = adapter
        flowObserver(viewModel.viewStates()) { state -> stateObserver(state) }

    }

    private fun stateObserver(state: HomeState) {
        Log.e("kart", "load = ${state.isLoading} items = ${state.categories} ")
        adapter.submitList(state.categories)
    }
}