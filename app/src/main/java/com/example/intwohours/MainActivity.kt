package com.example.intwohours

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.intwohours.adapter.EventsAdapter
import com.example.intwohours.model.EventData
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mDataBase: DatabaseReference
    private lateinit var eventList:ArrayList<EventData>
    private lateinit var mAdapter:EventsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        eventList = ArrayList()
        mAdapter = EventsAdapter(this,eventList)
        recyclerEvents.layoutManager = LinearLayoutManager(this)
        recyclerEvents.setHasFixedSize(true)
        // recyclerAnimals.adapter = mAdapter
        /**getData firebase*/
        getEventsData()
        //val search = findViewById<TextView>(R.id.main_search)


    }

    private fun getEventsData() {

        mDataBase = FirebaseDatabase.getInstance().getReference("Animals")
        mDataBase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (eventSnapshot in snapshot.children) {
                        val event = eventSnapshot.getValue(EventData::class.java)
                        eventList.add(event!!)
                    }
                    recyclerEvents.adapter = mAdapter
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
/*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        defining activity main components
        val search = findViewById<TextView>(R.id.main_search)
        val shapeable = findViewById<ShapeableImageView>(R.id.main_shapeable)
        val recyclerView = findViewById<RecyclerView>(R.id.main_recyclerView)

        val itemList = ArrayList<EventData>()
        val adapter = CategoryAdapter(itemList)

        setupRecyclerView(adapter, recyclerView)

        val db = FirebaseDatabase.getInstance().reference
        val valueEventListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (i in snapshot.children) {
                    itemList.add(EventData(i.key.toString(), i.child("image").value.toString()))
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity, "Error !", Toast.LENGTH_SHORT).show()
            }
        }
        db.child("category").addListenerForSingleValueEvent(valueEventListener)

    }

    fun setupRecyclerView(adapter: CategoryAdapter, recyclerView: RecyclerView){
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}*/
