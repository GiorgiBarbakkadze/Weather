package com.gb.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.gb.presentation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    private var navController: NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainer) as? NavHostFragment
                ?: NavHostFragment.create(R.navigation.navigation)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, navHostFragment)
            .setPrimaryNavigationFragment(navHostFragment)
            .commitNow()

        navController = navHostFragment.navController

    }

}











