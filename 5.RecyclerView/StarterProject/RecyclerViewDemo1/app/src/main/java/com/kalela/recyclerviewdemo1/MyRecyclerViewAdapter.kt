package com.kalela.recyclerviewdemo1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class MyRecyclerViewAdapter(private val fruitsList: List<String>, private val clickListener:(String)->Unit) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val listItem: View = layoutInflater.inflate(R.layout.list_item, parent, false)

        return MyViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return fruitsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(fruitsList[position], clickListener)

    }

}

class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(fruit: String, clickListener:(String)->Unit) {
        view.name_text_view.text = fruit
        view.setOnClickListener {
            clickListener(fruit)
        }
    }
}