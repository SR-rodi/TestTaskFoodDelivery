package ru.sr.testtaskfooddelivery.feature_home.presentation.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.sr.testtaskfooddelivery.base.BaseFragment
import ru.sr.testtaskfooddelivery.feature_home.databinding.FragmentHomeBinding
import ru.sr.testtaskfooddelivery.feature_home.presentation.home.state.HomeState
import ru.sr.testtaskfooddelivery.feature_home.presentation.root.adapter.HomeAdapter

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val adapter by lazy { HomeAdapter(onClickCategory = ::onClickItem) }
    private val viewModel by viewModel<HomeViewModel>()

    override fun initBinding(inflater: LayoutInflater) = FragmentHomeBinding.inflate(inflater)

    private fun onClickItem(item: String) = findNavController()
        .navigate(HomeFragmentDirections.actionBlankFragmentToCategoryFragment(item))

    override fun onAttach(context: Context) {
        super.onAttach(context)
        findNavController().navigate(ru.sr.testtaskfooddelivery.core.R.id.locationFragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeRecyclerView.adapter = adapter
        flowObserver(viewModel.viewStates()) { state -> stateObserver(state) }

        binding.error.repeatButton.setOnClickListener {
            viewModel.getCategories()
        }
    }

    private fun stateObserver(state: HomeState) {
        adapter.submitList(state.categories)
        binding.apply {
            progressBar.isVisible = state.isLoading
            error.network.isVisible = state.isError
        }
    }
}