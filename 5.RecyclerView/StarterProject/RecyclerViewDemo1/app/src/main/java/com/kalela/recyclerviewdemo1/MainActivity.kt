package com.kalela.recyclerviewdemo1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val fruitsList = listOf("Mango", "Apple", "Banana")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        my_recycler_view.setBackgroundColor(Color.YELLOW)
        my_recycler_view.layoutManager = LinearLayoutManager(this)
        my_recycler_view.adapter = MyRecyclerViewAdapter(fruitsList, {selectedFruitItem: String->listItemClicked(selectedFruitItem)});
    }

    private fun listItemClicked(fruit : String) {
        Toast.makeText(this@MainActivity, "Clicked fruit is $fruit", Toast.LENGTH_LONG).show()
    }
}