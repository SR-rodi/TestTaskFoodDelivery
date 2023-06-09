package ru.sr.testtaskfooddelivery.feature_location.domain.wrapper

import com.google.android.gms.location.FusedLocationProviderClient

internal interface FusedClient {
    val client: FusedLocationProviderClient
}

