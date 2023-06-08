package ru.sr.testtaskfooddelivery.feature_home.presentation.dishe

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.sr.testtaskfooddelivery.base.BaseFragment
import ru.sr.testtaskfooddelivery.feature_home.databinding.FragmentDishesBinding
import ru.sr.testtaskfooddelivery.feature_home.presentation.dishe.model.DisheUiModel
import ru.sr.testtaskfooddelivery.feature_home.presentation.dishe.model.Tag
import ru.sr.testtaskfooddelivery.feature_home.presentation.dishe.state.DishesState
import ru.sr.testtaskfooddelivery.feature_home.presentation.root.adapter.HomeAdapter

class DishesFragment : BaseFragment<FragmentDishesBinding>() {

    private val viewModel by viewModel<DishesViewModel>()
    private val args by navArgs<DishesFragmentArgs>()

    private val dishAdapter by lazy { HomeAdapter(onClickDishe = ::onClickDishe) }
    private val tagsAdapter by lazy { HomeAdapter(onClickTag = ::onClickTag) }

    private fun onClickDishe(item: DisheUiModel) = findNavController()
        .navigate(DishesFragmentDirections.actionCategoryFragmentToProductDialogFragment(item))

    private fun onClickTag(tag: Tag) {
        viewModel.getDishesByTag(tag)
    }

    override fun initBinding(inflater: LayoutInflater) = FragmentDishesBinding.inflate(inflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("Kart", "category = ${args.categoryName}")
        bindAdapter()
        flowObserver(viewModel.viewStates()) { state -> stateObserver(state) }

        binding.error.repeatButton.setOnClickListener {
            viewModel.getAllDishes()
        }
    }

    private fun stateObserver(state: DishesState) {
        dishAdapter.submitList(state.dishes)
        tagsAdapter.submitList(state.tags)
        binding.error.network.isVisible = state.isError
        binding.progressBar.isVisible = state.isLoading
    }

    private fun bindAdapter() = binding.apply {
        dishesRecyclerView.adapter = dishAdapter
        tagsRecyclerView.adapter = tagsAdapter
    }
}