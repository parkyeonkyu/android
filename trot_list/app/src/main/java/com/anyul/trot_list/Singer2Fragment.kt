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


class Singer2Fragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_singer2, container, false)

        val songList = mutableListOf<String>()
        songList.add("별빛 같은 나의 사랑")
        songList.add("사랑의 콜센터")
        songList.add("영웅시대")
        songList.add("이제 나만 믿어요")
        songList.add("별빛 같은 나의 사랑")
        songList.add("사랑의 콜센터")
        songList.add("영웅시대")
        songList.add("이제 나만 믿어요")
        songList.add("별빛 같은 나의 사랑")
        songList.add("사랑의 콜센터")
        songList.add("영웅시대")
        songList.add("이제 나만 믿어요")
        songList.add("별빛 같은 나의 사랑")
        songList.add("사랑의 콜센터")
        songList.add("영웅시대")
        songList.add("이제 나만 믿어요")
        songList.add("별빛 같은 나의 사랑")
        songList.add("사랑의 콜센터")
        songList.add("영웅시대")
        songList.add("이제 나만 믿어요")
        songList.add("별빛 같은 나의 사랑")
        songList.add("사랑의 콜센터")
        songList.add("영웅시대")
        songList.add("이제 나만 믿어요")
        songList.add("별빛 같은 나의 사랑")
        songList.add("사랑의 콜센터")
        songList.add("영웅시대")
        songList.add("이제 나만 믿어요")
        songList.add("별빛 같은 나의 사랑")
        songList.add("사랑의 콜센터")
        songList.add("영웅시대")
        songList.add("이제 나만 믿어요")


        val rv = view.findViewById<RecyclerView>(R.id.singRV)
        val rvAdapter = RVAdapter(songList);
        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(context)


        val image1= view.findViewById<ImageView>(R.id.image1)
        image1.setOnClickListener{
            it.findNavController().navigate(R.id.action_singer2Fragment_to_singer1Fragment)
        }
        val image3= view.findViewById<ImageView>(R.id.image3)
        image3.setOnClickListener{
            it.findNavController().navigate(R.id.action_singer2Fragment_to_singer3Fragment)
        }
        return view
    }
}