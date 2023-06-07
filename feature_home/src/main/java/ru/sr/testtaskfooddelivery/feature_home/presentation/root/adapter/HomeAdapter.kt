package ru.sr.testtaskfooddelivery.feature_home.presentation.root.adapter

import ru.sr.adapter.ListDelegateAdapter
import ru.sr.testtaskfooddelivery.feature_home.presentation.root.HomeDisplayItem
import ru.sr.testtaskfooddelivery.feature_home.presentation.home.delegate.categoryDelegate

class HomeAdapter(onClickItem: (String) -> Unit) :
    ListDelegateAdapter<HomeDisplayItem>(HomeDisplayDiffUtil()) {
    init {
        addDelegate(categoryDelegate(onClickItem))
    }
}