package ru.sr.testtaskfooddelivery.feature_location.data

import android.content.Context
import android.location.Geocoder
import ru.sr.testtaskfooddelivery.feature_location.domain.wrapper.GeocoderClient
import java.util.Locale

internal class GeocoderClientImpl(context: Context) : GeocoderClient {

    override val client = Geocoder(context, Locale.getDefault())

}