package com.example.registrationthengames.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.registrationthengames.R
import com.squareup.picasso.Picasso

class MyAdapterForScreenshots : RecyclerView.Adapter<MyAdapterForScreenshots.ViewHolder>() {

    private val dataResults = mutableListOf<String>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MyAdapterForScreenshots.ViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.screenshots_view, parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(holder: MyAdapterForScreenshots.ViewHolder, position: Int) {
        val item = dataResults[position]
        holder.bind(item)
    }

    override fun getItemCount() = dataResults.size

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(listResults: List<String>) {
        dataResults.clear()
        dataResults.addAll(listResults)
        notifyDataSetChanged()
    }

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val icon: ImageView = item.findViewById(R.id.ImageScreenView)

        fun bind(item: String) {

            Picasso.get().load(item).into(icon)
        }
    }

}