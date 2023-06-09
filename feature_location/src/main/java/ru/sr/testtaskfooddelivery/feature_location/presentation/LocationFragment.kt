package ru.sr.testtaskfooddelivery.feature_location.presentation

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.sr.testtaskfooddelivery.SetToolbar
import ru.sr.testtaskfooddelivery.base.BaseFragment
import ru.sr.testtaskfooddelivery.feature_location.R
import ru.sr.testtaskfooddelivery.feature_location.databinding.FragmentLocationBinding

class LocationFragment : BaseFragment<FragmentLocationBinding>() {

    private val viewModel by viewModel<LocationViewModel>()

    private val launcher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { map ->
            if (map.values.isNotEmpty() && map.values.all { it }) {
                viewModel.getPosition()
            }
        }

    override fun initBinding(inflater: LayoutInflater) = FragmentLocationBinding.inflate(inflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermission()
        flowObserver(viewModel.viewStates()) { state ->
            (activity as? SetToolbar)?.setTitle(
                state.userPosition.cityName,
                state.userPosition.date
            )
            if (state.isErrorLocation)
                Toast.makeText(
                    requireContext(),
                    resources.getString(ru.sr.testtaskfooddelivery.core_ui.R.string.error_location),
                    Toast.LENGTH_SHORT
                ).show()
            if (state.isNavigate) findNavController().popBackStack()
        }
    }

    private fun checkPermission() {
        if (PERMISSIONS.all { permission ->
                ContextCompat.checkSelfPermission(
                    requireContext(), permission
                ) == PackageManager.PERMISSION_GRANTED
            }) {
            viewModel.getPosition()
        } else launcher.launch(PERMISSIONS)
    }

    private companion object {
        val PERMISSIONS = arrayOf(
            Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION
        )
    }
}