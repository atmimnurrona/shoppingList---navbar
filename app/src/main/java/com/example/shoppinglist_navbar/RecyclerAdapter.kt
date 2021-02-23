package com.example.shoppinglist_navbar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemName: TextView = itemView.findViewById(R.id.tvItemName)
        var itemQuantity: TextView = itemView.findViewById(R.id.tvQuantity)
        var itemNote: TextView = itemView.findViewById(R.id.tvNote)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = ItemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemName.text = ItemList[position].itemName
        holder.itemQuantity.text = ItemList[position].quantity.toString()
        holder.itemNote.text = ItemList[position].note

    }
}