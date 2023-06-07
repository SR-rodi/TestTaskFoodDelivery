package ru.sr.testtaskfooddelivery.feature_home

import android.view.LayoutInflater
import ru.sr.testtaskfooddelivery.base.BaseFragment
import ru.sr.testtaskfooddelivery.feature_home.databinding.FragmentCategoryBinding

class CategoryFragment : BaseFragment<FragmentCategoryBinding>() {
    override fun initBinding(inflater: LayoutInflater) = FragmentCategoryBinding.inflate(inflater)
}