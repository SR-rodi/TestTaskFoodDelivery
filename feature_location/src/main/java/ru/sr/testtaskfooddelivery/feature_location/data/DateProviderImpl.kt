package ru.sr.testtaskfooddelivery.feature_location.data

import android.annotation.SuppressLint
import ru.sr.testtaskfooddelivery.feature_location.domain.wrapper.DateProvider
import ru.sr.testtaskfooddelivery.feature_location.domain.wrapper.LocationDateWrapper
import java.text.SimpleDateFormat

class DateProviderImpl(
    private val locationDateWrapper: LocationDateWrapper,
) : DateProvider {

    @SuppressLint("SimpleDateFormat")
    override fun getDate(): String {
        val simpleDateFormat = SimpleDateFormat("dd MMMM,yyyy")
        return simpleDateFormat.format(locationDateWrapper.date)
    }
}