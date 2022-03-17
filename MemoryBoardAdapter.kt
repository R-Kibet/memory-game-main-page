package com.example.anew

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.min

class MemoryBoardAdapter(private val context: Context, private val numPieces: Int) :
    RecyclerView.Adapter<MemoryBoardAdapter.ViewHolder>() {

    /*create a margin between the card view
       use a companion object so as to access the constants
    */

    companion object{
        private const val Margin_Size = 10
        private const val TAG = "MemoryBoardAdapter"
    }


    //creates  view of the recycler view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        //setting height and with dynamically

        val cardWidth = parent.width /2 - (2 * Margin_Size )
        val cardHeight = parent.height /4 - (2 * Margin_Size)
        val cardSideLength = min(cardWidth, cardHeight)



       val view =  LayoutInflater.from(context).inflate(R.layout.memory_card,parent,false)

        // setting the view to be cardside length
       val layoutParams =  view.findViewById<CardView>(R.id.cardView).layoutParams
               as ViewGroup.MarginLayoutParams

        layoutParams.height = cardSideLength
        layoutParams.width = cardSideLength
        layoutParams.setMargins(Margin_Size, Margin_Size, Margin_Size, Margin_Size)


       return ViewHolder(view)
    }

    //Taking data at the position and binding to the view holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(position)
    }

    //How many elements are in the recycler view
    override fun getItemCount() = numPieces


    inner class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //setting  click on the image button
        private val imageButton = itemView.findViewById<ImageButton>(R.id.imageButton)

        fun bind(position: Int) {

            imageButton.setOnClickListener {
                Log.i(TAG, "Clicked on position $position") // log i ->  represent info level
            }
        }
    }
}


