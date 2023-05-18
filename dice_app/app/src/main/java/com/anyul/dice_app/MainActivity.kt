package com.anyul.dice_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.anyul.dice_app.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var testList = mutableListOf<String>()
        testList.add("a")
        testList.add("b")
        testList.add("c")
        Log.d("MainActivity", testList.toString())
        Log.d("MainActivity", testList[0])
        Log.d("MainActivity", testList[1])
        Log.d("MainActivity", testList[2])

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        binding.diceStartBtn.setOnClickListener{
            Toast.makeText(this, "주사위 Go!", Toast.LENGTH_SHORT).show()
            val random1 = Random.nextInt(1, 6).toString();
            val random2 = Random.nextInt(1, 6).toString();

            binding.diceImageView1.setImageResource(resources.getIdentifier
                ("dice_$random1"
                ,"drawable",packageName))
            binding.diceImageView2.setImageResource(resources.getIdentifier("dice_$random2","drawable",packageName));
            Log.d("MainActivity",random1)
            Log.d("MainActivity",random2)
        }
    }
}