package com.example.registrationthengames.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.registrationthengames.R
import com.example.registrationthengames.modelGames.GameResult
import com.example.registrationthengames.modelGames.ScreenshotResponse
import com.squareup.picasso.Picasso

class MyAdapter(
    private val onClick: (GameResult) -> Unit
) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private val dataResults = mutableListOf<GameResult>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        val item = dataResults[position]
        holder.bind(item)
    }

    override fun getItemCount() = dataResults.size


    @SuppressLint("NotifyDataSetChanged")
    fun setItems(listResults: List<GameResult>) {
        dataResults.clear()
        dataResults.addAll(listResults)
        notifyDataSetChanged()
    }

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val icon: ImageView = item.findViewById(R.id.ImageView)
        private val name: TextView = item.findViewById(R.id.nameGameTextView)

        fun bind(item: GameResult) {
         Picasso.get().load(item.imageUrl).into(icon)
            name.text = item.name
            itemView.setOnClickListener { (onClick.invoke(item)) }
        }
    }
}