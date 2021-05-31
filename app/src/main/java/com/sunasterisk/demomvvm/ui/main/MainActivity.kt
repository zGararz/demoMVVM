package com.sunasterisk.demomvvm.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.sunasterisk.demomvvm.R
import com.sunasterisk.demomvvm.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initComponents()

    }

    private fun initComponents() {
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            val navController = Navigation.findNavController(this@MainActivity, R.id.fragmentHost)
            bottomNav.setupWithNavController(navController)
            bottomNav.setOnNavigationItemSelectedListener {
                if (it.itemId != bottomNav.selectedItemId) {
                    NavigationUI.onNavDestinationSelected(it, navController)
                }
                true
            }
        }
    }
}
