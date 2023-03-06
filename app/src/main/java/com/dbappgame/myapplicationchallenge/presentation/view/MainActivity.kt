package com.dbappgame.myapplicationchallenge.presentation.view

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.dbappgame.myapplicationchallenge.R
import com.dbappgame.myapplicationchallenge.databinding.ActivityMainBinding
import com.dbappgame.myapplicationchallenge.presentation.viewmodel.DogViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: DogViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observers()

        binding.btnDog.setOnClickListener {
            viewModel.getDog()
        }

    }


    private fun observers(){
        viewModel.dog.observe(this){
            Glide.with(applicationContext).load(it.message).into(binding.imgDog)
        }

        viewModel.error.observe(this){
            Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
        }
        viewModel.isLoading.observe(this){ isLoading ->
            binding.pgLoading.isLoading(isLoading)
        }
    }

}


fun View.isLoading(isLoading: Boolean){
    visibility = if (isLoading) View.VISIBLE
    else  View.GONE
}