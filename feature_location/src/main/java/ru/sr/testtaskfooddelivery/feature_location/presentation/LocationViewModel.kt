package ru.sr.testtaskfooddelivery.feature_location.presentation

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.sr.testtaskfooddelivery.base.BaseViewModel
import ru.sr.testtaskfooddelivery.feature_location.domain.usecase.LocationUseCase
import ru.sr.testtaskfooddelivery.feature_location.domain.usecase.RemoveFusedLocationUseCse
import ru.sr.testtaskfooddelivery.feature_location.mapper.toUi
import ru.sr.testtaskfooddelivery.feature_location.presentation.state.MainState
import ru.sr.testtaskfooddelivery.wrapper.DispatcherWrapper

class LocationViewModel(
    private val locationUseCase: LocationUseCase,
    private val removeFusedLocationUseCse: RemoveFusedLocationUseCse,
    private val dispatcher: DispatcherWrapper,
) : BaseViewModel<MainState>(MainState()) {

    fun getPosition() {
        var counter = 0
        viewModelScope.launch(dispatcher.io) {
            var userDate = locationUseCase.getUserData()
            while (userDate.cityName == "" && counter <= MAX_COUNTER) {
                userDate = locationUseCase.getUserData()
                delay(500)
                counter++
            }
            val isError = counter >= 15

            viewState = viewState.copy(
                userPosition = userDate.toUi(),
                isErrorLocation = isError,
                isNavigate = true
            )
        }
    }

    fun removeLocation() {
        removeFusedLocationUseCse.remove()
    }

    private companion object {
        const val MAX_COUNTER = 15
    }

}