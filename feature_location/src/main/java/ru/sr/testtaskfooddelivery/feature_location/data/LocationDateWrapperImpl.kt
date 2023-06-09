package ru.sr.testtaskfooddelivery.feature_location.data

import ru.sr.testtaskfooddelivery.feature_location.domain.wrapper.LocationDateWrapper
import java.util.Date

class LocationDateWrapperImpl : LocationDateWrapper {
    override val date = Date()
}

