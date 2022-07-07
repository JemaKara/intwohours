package com.example.intwohours

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.intwohours.adapter.EventsAdapter
import com.example.intwohours.databinding.ActivityMainBinding
import com.example.intwohours.model.EventData
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {
    lateinit var mDataBase: DatabaseReference
    private lateinit var eventList:ArrayList<EventData>
    private lateinit var mAdapter:EventsAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        eventList = ArrayList()
        mAdapter = EventsAdapter(this,eventList)
        binding.recyclerEvents.layoutManager = LinearLayoutManager(this)
        binding.recyclerEvents.setHasFixedSize(true)
        // recyclerAnimals.adapter = mAdapter
        /**getData firebase*/
        getEventsData()
        //val search = findViewById<TextView>(R.id.main_search)


    }

    private fun getEventsData() {

        mDataBase = FirebaseDatabase.getInstance().getReference("Events")
        mDataBase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (eventSnapshot in snapshot.children) {
                        val event = eventSnapshot.getValue(EventData::class.java)
                        eventList.add(event!!)
                    }
                    binding.recyclerEvents.adapter = mAdapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(
                    this@MainActivity,
                    error.message, Toast.LENGTH_SHORT
                ).show()
            }

        })
    }

}

