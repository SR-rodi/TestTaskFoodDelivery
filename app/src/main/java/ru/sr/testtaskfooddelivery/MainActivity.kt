package ru.sr.testtaskfooddelivery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import ru.sr.testtaskfooddelivery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavView.setupWithNavController(navController)
    }
}