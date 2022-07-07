package com.example.intwohours.view

import android.R.attr.button
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.intwohours.databinding.ActivityMainBinding
import com.example.intwohours.databinding.EventActivityBinding
import com.example.intwohours.model.EventData
import com.example.intwohours.uitel.getProgessDrawable
import com.example.intwohours.uitel.loadImage


class ChosenEvent : AppCompatActivity() {
    private lateinit var binding: EventActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = EventActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        /**get Data*/
        val eventIntent = intent
        val evenTitle = eventIntent.getStringExtra("title")
        val eventInfo = eventIntent.getStringExtra("info")
        val eventImage = eventIntent.getStringExtra("image")

        /**call text and images*/
        binding.evenitle.text = evenTitle
        binding.info.text = eventInfo
        binding.image.loadImage(eventImage, getProgessDrawable(this))

    }
}