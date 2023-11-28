package com.timepicker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.timepicker.R
import com.timepicker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            //.add(R.id.fcContainer, DatePickerFragment())
            //.add(R.id.fcContainer, TimePickerFragment())
            .add(R.id.fcContainer, NumberPickerFragment())
            .commit()
    }
}