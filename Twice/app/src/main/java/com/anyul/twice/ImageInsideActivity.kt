package com.anyul.twice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ImageInsideActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_inside)

        val data = intent.getStringExtra("data");

        val imageViewer = findViewById<ImageView>(R.id.imgViewer)

        imageViewer.setImageResource(resources.getIdentifier("member_$data","drawable",packageName));
    }
}