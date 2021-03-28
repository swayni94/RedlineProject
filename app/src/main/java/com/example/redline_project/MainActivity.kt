package com.example.redline_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.redline_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val appComponents by lazy { MainApplication.appComponent }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponents.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        val navController: NavController = Navigation.findNavController(this, R.id.fragment_view_main_container)
        navController.navigate(R.id.firstFragment_navigation)
    }
}