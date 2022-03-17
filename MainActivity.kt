package com.example.anew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    //lateinit - variables will not be created at the time of initialization
    private lateinit var rvBoard : RecyclerView
    private lateinit var  moves: TextView
    private lateinit var  pairs :TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //initialize
        rvBoard = findViewById(R.id.recView)
        moves = findViewById(R.id.moves)
        pairs = findViewById(R.id.pairs)


        //recyclerview = contains layout manager and adapter

        //creating adapter
        rvBoard.adapter = MemoryBoardAdapter(this,8) //context and how many total elements in the grid

        //for perfomance optimization
        rvBoard.setHasFixedSize(true)
        

       //creating layout manager
        //grid layout manager creates the grid effect - takes 2 parameters context , columns
        rvBoard.layoutManager = GridLayoutManager(this,2)//hard coded 2 columns but later shall change to dynamic


        //edge effect - overscoll mode= never


    }
}