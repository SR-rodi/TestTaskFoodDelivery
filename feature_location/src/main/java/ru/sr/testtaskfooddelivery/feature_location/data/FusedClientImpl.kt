package ru.sr.testtaskfooddelivery.feature_location.data

import android.content.Context
import com.google.android.gms.location.LocationServices
import ru.sr.testtaskfooddelivery.feature_location.domain.wrapper.FusedClient

internal class FusedClientImpl(context: Context) : FusedClient {

    override val client = LocationServices.getFusedLocationProviderClient(context)

}