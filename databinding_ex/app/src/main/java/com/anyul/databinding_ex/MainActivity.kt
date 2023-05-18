package com.anyul.databinding_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.anyul.databinding_ex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1번방식 - findviewById
        val btn = findViewById<Button>(R.id.textBtnId)
        btn.setOnClickListener{
            //Toast.makeText(this,"click",Toast.LENGTH_LONG).show()
        }

        //2번방식 - Databinding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.textBtnId.setOnClickListener{
            Toast.makeText(this,"click",Toast.LENGTH_LONG).show()
        }

        var value = "여기는 value입니다!"
        val value2 = "여기는 value2입니다"

        value = "여기는 value가 아닙니다~!~!~@@~~!"

        Log.d("MainActivity",value)
    }
}