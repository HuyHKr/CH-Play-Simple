package com.example.chplaysimple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val titleArray = arrayListOf("For you", "Top charts","Other devices","Phim","Sach")
        val adapterTitle = ArrayAdapter<String>(/* context = */ this,/*layout*/
            android.R.layout.simple_list_item_1,titleArray);

        //title
        val titleView = findViewById<RecyclerView>(R.id.rcTitle)
        titleView.adapter = TitleAdapter(titleArray);
        titleView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        //body
        val myData = arrayListOf<ArrayList<ItemModel>>()
        repeat(6){
            myData.add(ArrayList<ItemModel>())
        }
        val nameArray = arrayListOf<String>("Among Us",
            "Instagram",
            "Fortnite",
            "WhatsApp",
            "PUBG Mobile",
            "TikTok",
            "Candy Crush Saga",
            "Facebook",
            "Twitter",
            "Snapchat",
            "Minecraft",
            "Netflix",
            "Zoom",
            "Google Maps",
            "Subway Surfers",
            "Messenger",
            "WhatsApp Messenger",
            "Gmail",
            "Twitter",
            "Temple Run",
            "LinkedIn",
            "Amazon",
            "Spotify",
            "Pinterest",
            "Telegram",
            "Hill Climb Racing",
            "Google Chrome",
            "Snapseed",
            "Pinterest",
            "Microsoft Word",
            "Garena Free Fire",
            "WeChat",
            "Viber","Huy")
        val search_bar = findViewById<AutoCompleteTextView>(R.id.search);
        search_bar.setAdapter(ArrayAdapter(this, android.R.layout.simple_list_item_1,nameArray));
        repeat(34){

           myData[it/6].add(ItemModel(resources.getIdentifier("image__${it}_","drawable",packageName),nameArray[it]))
        }
        val body = findViewById<RecyclerView>(R.id.recyclerView);
        body.adapter = BodyAdapter(myData)
        body.layoutManager = LinearLayoutManager(this)


    }
    class TitleAdapter(val items:ArrayList<String>): RecyclerView.Adapter<TitleAdapter.myViewHolder>(){
        class myViewHolder(val view: View):RecyclerView.ViewHolder(view){
            var textView = view.findViewById<TextView>(R.id.textViews);
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.title_item,parent,false);
            return myViewHolder(itemView)
        }

        override fun getItemCount(): Int {
            return items.size;
        }

        override fun onBindViewHolder(holder: myViewHolder, position: Int) {
            holder.textView.text = items[position];
        }
    }
}