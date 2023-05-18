package com.anyul.listview_second_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list_item = mutableListOf<ListViewModel>()
        list_item.add(ListViewModel("A","B"))
        list_item.add(ListViewModel("C","D"))
        list_item.add(ListViewModel("E","F"))

        var adapter = ListViewAdapter(list_item)
        val listview = findViewById<ListView>(R.id.mainListView)
        listview.adapter = adapter
        listview.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this,list_item[position].text2,Toast.LENGTH_LONG).show()
        }

    }

}