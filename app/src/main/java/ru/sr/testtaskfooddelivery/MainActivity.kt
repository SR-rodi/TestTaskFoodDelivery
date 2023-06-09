package ru.sr.testtaskfooddelivery

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.isVisible
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.sr.testtaskfooddelivery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), SetToolbar {

    private lateinit var binding: ActivityMainBinding
    private val navController by lazy {
        (supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment)
            .navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
        addDestinationListener()

        binding.backArrow.setOnClickListener {
            navController.popBackStack()
        }
    }

    private fun addDestinationListener() {
        navController.addOnDestinationChangedListener { _, destination, bundle ->

            binding.toolbar.isVisible =
                destination.id != ru.sr.testtaskfooddelivery.core.R.id.locationFragment
            binding.bottomNavView.isVisible =
                destination.id != ru.sr.testtaskfooddelivery.core.R.id.locationFragment

            if (destination.id != ru.sr.testtaskfooddelivery.feature_home.R.id.productDialogFragment) {
                val newTitle = bundle?.getString(destination.arguments.keys.last())
                binding.apply {
                    categoryTitle.text = newTitle
                    cityContainer.isVisible = newTitle == null
                    locationIcon.isVisible = newTitle == null
                    categoryTitle.isVisible = newTitle != null
                    backArrow.isVisible = newTitle != null
                }
            }
        }
    }

    private fun setupNavigation() {
        binding.bottomNavView.setupWithNavController(navController)
    }

    override fun setTitle(cityName: String, date: String) {
        binding.cityTitle.text = cityName
        binding.cityDate.text = date
    }
}