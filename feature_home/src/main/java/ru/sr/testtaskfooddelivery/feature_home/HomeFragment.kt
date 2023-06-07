package ru.sr.testtaskfooddelivery.feature_home

import android.view.LayoutInflater
import ru.sr.testtaskfooddelivery.base.BaseFragment
import ru.sr.testtaskfooddelivery.feature_home.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun initBinding(inflater: LayoutInflater) = FragmentHomeBinding.inflate(inflater)
}