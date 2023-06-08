package ru.sr.testtaskfooddelivery.feature_home.presentation.dishe

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.sr.testtaskfooddelivery.base.BaseFragment
import ru.sr.testtaskfooddelivery.feature_home.databinding.FragmentDishesBinding
import ru.sr.testtaskfooddelivery.feature_home.presentation.dishe.model.DisheUiModel
import ru.sr.testtaskfooddelivery.feature_home.presentation.dishe.model.Tag
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

        binding.dishesRecyclerView.adapter = dishAdapter
        binding.tagsRecyclerView.adapter = tagsAdapter
        flowObserver(viewModel.viewStates()) { state ->
            dishAdapter.submitList(state.dishes)
            tagsAdapter.submitList(state.tags)
        }
    }

}