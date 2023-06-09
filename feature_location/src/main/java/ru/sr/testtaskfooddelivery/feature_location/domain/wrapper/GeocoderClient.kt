package ru.sr.testtaskfooddelivery.feature_location.domain.wrapper

import android.location.Geocoder

internal interface GeocoderClient {

    val client: Geocoder
}