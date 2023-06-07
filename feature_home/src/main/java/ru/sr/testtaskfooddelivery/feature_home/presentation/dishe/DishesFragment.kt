package ru.sr.testtaskfooddelivery.feature_home.presentation.dishe

import android.view.LayoutInflater
import ru.sr.testtaskfooddelivery.base.BaseFragment
import ru.sr.testtaskfooddelivery.feature_home.databinding.FragmentDishesBinding

class DishesFragment : BaseFragment<FragmentDishesBinding>() {
    override fun initBinding(inflater: LayoutInflater) = FragmentDishesBinding.inflate(inflater)
}