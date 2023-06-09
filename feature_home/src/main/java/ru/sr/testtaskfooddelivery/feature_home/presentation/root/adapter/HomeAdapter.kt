package ru.sr.testtaskfooddelivery.feature_home.presentation.root.adapter

import ru.sr.adapter.ListDelegateAdapter
import ru.sr.testtaskfooddelivery.feature_home.presentation.dish.delegate.dishDelegate
import ru.sr.testtaskfooddelivery.feature_home.presentation.dish.delegate.tagDelegate
import ru.sr.testtaskfooddelivery.feature_home.presentation.dish.model.DishUiModel
import ru.sr.testtaskfooddelivery.feature_home.presentation.dish.model.Tag
import ru.sr.testtaskfooddelivery.feature_home.presentation.root.HomeDisplayItem
import ru.sr.testtaskfooddelivery.feature_home.presentation.home.delegate.categoryDelegate

class HomeAdapter(
    onClickCategory: (String) -> Unit = {},
    onClickDishe: (DishUiModel) -> Unit = {},
    onClickTag: (Tag) -> Unit = {},
) : ListDelegateAdapter<HomeDisplayItem>(HomeDisplayDiffUtil()) {
    init {
        addDelegate(categoryDelegate(onClickCategory))
        addDelegate(dishDelegate(onClickDishe))
        addDelegate(tagDelegate(onClickTag))
    }
}