package com.example.chplaysimple

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BodyAdapter(val items:ArrayList<ArrayList<ItemModel>>):
    RecyclerView.Adapter<BodyAdapter.myViewHolder>() {
    class myViewHolder(val view: View):RecyclerView.ViewHolder(view){
        var context = view.context;
        var titleItem = view.findViewById<TextView>(R.id.titleItem);
        var endButton = view.findViewById<ImageButton>(R.id.endButton)
        var rv = view.findViewById<RecyclerView>(R.id.rvItem);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.outer_item,parent,false);
        return myViewHolder(view);
    }

    override fun getItemCount(): Int =items.size

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val listTitle = arrayListOf("Popular app","Top game","Education","Flight booking","Banking","Coding");
        holder.titleItem.text = listTitle[position];
        holder.rv.adapter = InnerAdapter(items[position])
        holder.rv.layoutManager = LinearLayoutManager(holder.context,LinearLayoutManager.HORIZONTAL,false)
        holder.endButton.setOnClickListener{
            holder.rv.scrollToPosition(items[position].size-1)
        }
    }
}