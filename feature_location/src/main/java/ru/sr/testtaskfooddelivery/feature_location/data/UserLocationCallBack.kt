package ru.sr.testtaskfooddelivery.feature_location.data

import android.util.Log
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationResult
import ru.sr.testtaskfooddelivery.feature_location.domain.wrapper.GeocoderClient
import ru.sr.testtaskfooddelivery.feature_location.domain.wrapper.PositionCallBack

internal class UserLocationCallBack(
    private val geocoder: GeocoderClient,
) : LocationCallback(), PositionCallBack {

    private var lat: Double? = null
    private var lon: Double? = null

    override fun onLocationResult(result: LocationResult) {
        lat = result.lastLocation?.latitude
        lon = result.lastLocation?.longitude
        Log.e("Kart", "resoult = ${result.lastLocation?.latitude}")
    }



    @Suppress("DEPRECATION")
    override fun getPosition(): String {
        Log.e("Kart", "la = $lat lon = $lon")
        if (lat == null && lon == null) return ""
        val address = geocoder.client.getFromLocation(lat!!, lon!!, 1)?.last()?.locality
        return address.toString()
    }
}