package com.anyul.mango_contents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class BookmarkActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth

    private val contentsModels = mutableListOf<ContentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookmark)

        val database = Firebase.database
        val myBookmarkRef = database.getReference("bookmark_ref")

        auth = Firebase.auth


        val recyclerview = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(baseContext, contentsModels)
        recyclerview.adapter = rvAdapter
        recyclerview.layoutManager = GridLayoutManager(this,2)

        myBookmarkRef
            .child(auth.currentUser?.uid.toString())
            .addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {

                    for(dataModel in snapshot.children){
                        Log.d("Datamodel", dataModel.toString())
                        contentsModels.add(dataModel.getValue(ContentsModel::class.java)!!)
                    }
                    rvAdapter.notifyDataSetChanged()
                }

                override fun onCancelled(error: DatabaseError) {
                   Log.e("Bookmark", "dbError")
                }

            })
    }
}