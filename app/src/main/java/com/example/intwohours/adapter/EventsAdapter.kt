package com.example.intwohours.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.intwohours.R
import com.example.intwohours.databinding.ItemListBinding
import com.example.intwohours.model.EventData
import com.squareup.picasso.Picasso

class EventsAdapter(
    var c: Context, var eventList: ArrayList<EventData>)
    : RecyclerView.Adapter<EventsAdapter.EventViewHolder>() {

    inner class EventViewHolder(var v: ItemListBinding): RecyclerView.ViewHolder(v.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val infilter = LayoutInflater.from(parent.context)
        val v = DataBindingUtil.inflate<ItemListBinding>(
            infilter,R.layout.item_list,parent,
            false
        )
        return EventViewHolder(v)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.v.isEvent = eventList[position]
    }

    override fun getItemCount(): Int {
        return eventList.size
    }


}