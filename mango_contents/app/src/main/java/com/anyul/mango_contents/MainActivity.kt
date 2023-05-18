package com.anyul.mango_contents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private  val items = mutableListOf<ContentsModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bookmarkButton = findViewById<TextView>(R.id.bookmarkBtn)
        bookmarkButton.setOnClickListener{
            val intent = Intent(this, BookmarkActivity::class.java)
            startActivity(intent)
        }

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/IdMkDvlwbE",
                "https://img.siksinhot.com/place/1463973074322424.jpg",
            "초원순두부"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/ZGMEfkrGQqQX",
                "https://mp-seoul-image-production-s3.mangoplate.com/462661_1607947782006087.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "그믐족발"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/0mJgYuBg7-6b",
                "https://mp-seoul-image-production-s3.mangoplate.com/2050161_1675829269004223.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "베르데브"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/rTPq-hyHWS",
                "https://mp-seoul-image-production-s3.mangoplate.com/10693/1618189_1614872507727_16622?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "알마또"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/IdMkDvlwbE",
                "https://img.siksinhot.com/place/1463973074322424.jpg",
                "초원순두부"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/ZGMEfkrGQqQX",
                "https://mp-seoul-image-production-s3.mangoplate.com/462661_1607947782006087.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "그믐족발"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/0mJgYuBg7-6b",
                "https://mp-seoul-image-production-s3.mangoplate.com/2050161_1675829269004223.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "베르데브"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/rTPq-hyHWS",
                "https://mp-seoul-image-production-s3.mangoplate.com/10693/1618189_1614872507727_16622?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "알마또"
            )
        )

        val recyclerview = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(baseContext, items)

        rvAdapter.itemClick = object :RVAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(baseContext, ViewActivity::class.java)
                intent.putExtra("url",items[position].url)
                intent.putExtra("title",items[position].titleText)
                intent.putExtra("imageUrl",items[position].imageUrl)
                startActivity(intent);
            }

        }

        recyclerview.adapter = rvAdapter
        recyclerview.layoutManager = GridLayoutManager(this,2)
    }
}