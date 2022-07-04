package com.example.intwohours.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.intwohours.R
import com.example.intwohours.uitel.getProgessDrawable
import com.example.intwohours.uitel.loadImage
import kotlinx.android.synthetic.main.event_activity.*
import kotlinx.android.synthetic.main.item_list.*


class ChosenEvent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.event_activity)

        /**get Data*/
        val eventIntent = intent
        val eventTitle = eventIntent.getStringExtra("evenTitle")
        val eventInfo = eventIntent.getStringExtra("info")
        val eventImage = eventIntent.getStringExtra("image")

        /**call text and images*/
        evenTitle.text = eventTitle
        info.text = eventInfo
        image.loadImage(eventImage, getProgessDrawable(this))
    }
    /**ok now run it */
}