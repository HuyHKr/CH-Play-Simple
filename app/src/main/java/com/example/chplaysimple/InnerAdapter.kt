package com.example.chplaysimple

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class InnerAdapter(val items:ArrayList<ItemModel>):RecyclerView.Adapter<InnerAdapter.myViewHolder>() {
    class myViewHolder(val view: View):RecyclerView.ViewHolder(view){
        var imageView = view.findViewById<ImageView>(R.id.image);
        var name = view.findViewById<TextView>(R.id.name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.inner_item,parent,false);
        return myViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.imageView.setImageResource(items[position].imageRes)
        holder.name.text = items[position].name

    }
}