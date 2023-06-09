package ru.sr.testtaskfooddelivery.feature_location.data

import android.annotation.SuppressLint
import android.os.Looper
import android.util.Log
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.Priority
import ru.sr.testtaskfooddelivery.feature_location.domain.repository.LocationRepository
import ru.sr.testtaskfooddelivery.feature_location.domain.wrapper.DateProvider
import ru.sr.testtaskfooddelivery.feature_location.domain.wrapper.FusedClient

internal class LocationRepositoryImpl(
    private val fusedClient: FusedClient,
    private val userLocationCallBack: UserLocationCallBack,
    private val dateProvider: DateProvider,
) : LocationRepository {

    init {
        initFusedLocation()
    }

    override fun getUserLocation(): String {
        return userLocationCallBack.getPosition()
    }

    override fun getDate(): String {
        return dateProvider.getDate()
    }

    @SuppressLint("MissingPermission")
    private fun initFusedLocation() {
        val request = LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 100_000).build()
       Log.e("kart","initFusedLocation()")
        fusedClient.client.requestLocationUpdates(
            request,
            userLocationCallBack,
            Looper.getMainLooper()
        )
    }

    override fun removeFusedClient() {
        fusedClient.client.removeLocationUpdates(userLocationCallBack)
    }
}