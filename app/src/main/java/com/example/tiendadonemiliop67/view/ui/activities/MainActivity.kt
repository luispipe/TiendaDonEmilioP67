package com.example.tiendadonemiliop67.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.tiendadonemiliop67.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.tiendadonemiliop67.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val REQUEST_PERMISSIONS_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        configNav()
    }

    fun configNav(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragContent) as NavHostFragment
        val navController = navHostFragment.navController
        findViewById<BottomNavigationView>(R.id.bnvMenu).setupWithNavController(navController)
    }
}