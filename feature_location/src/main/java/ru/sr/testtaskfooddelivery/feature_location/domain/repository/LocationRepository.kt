package ru.sr.testtaskfooddelivery.feature_location.domain.repository

interface LocationRepository {
    fun getUserLocation(): String
    fun getDate():String
}