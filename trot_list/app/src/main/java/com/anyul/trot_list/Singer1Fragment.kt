package com.anyul.trot_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Singer1Fragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_singer1, container, false)

        val songList = mutableListOf<String>()
        songList.add("막걸리 한잔")
        songList.add("고향역")
        songList.add("니가왜 거기서나와")
        songList.add("비상")
        songList.add("막걸리 한잔")
        songList.add("고향역")
        songList.add("니가왜 거기서나와")
        songList.add("비상")
        songList.add("막걸리 한잔")
        songList.add("고향역")
        songList.add("니가왜 거기서나와")
        songList.add("비상")
        songList.add("막걸리 한잔")
        songList.add("고향역")
        songList.add("니가왜 거기서나와")
        songList.add("비상")
        songList.add("막걸리 한잔")
        songList.add("고향역")
        songList.add("니가왜 거기서나와")
        songList.add("비상")


        val rv = view.findViewById<RecyclerView>(R.id.singRV)
        val rvAdapter = RVAdapter(songList);
        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(context)

        val image2= view.findViewById<ImageView>(R.id.image2)
        image2.setOnClickListener{
            it.findNavController().navigate(R.id.action_singer1Fragment_to_singer2Fragment)
        }
        val image3= view.findViewById<ImageView>(R.id.image3)
        image3.setOnClickListener{
            it.findNavController().navigate(R.id.action_singer1Fragment_to_singer3Fragment)
        }
        return view
    }
}