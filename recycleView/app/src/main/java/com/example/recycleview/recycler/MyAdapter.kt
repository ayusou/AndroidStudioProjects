package com.example.recycleview.recycler

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.R

class MyAdapter(private val dataset: List<String>):RecyclerView.Adapter<MyView>() {

    var clickPos: Int=RecyclerView.NO_POSITION
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)
        return MyView(view)
    }

    override fun getItemCount()= dataset.size

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.tvAnimales.text =dataset[position]
            if(position == clickPos){

                holder.tvAnimales.setTextColor(Color.WHITE)
                holder.tvAnimales.setBackgroundColor(Color.RED)

            }
        else{
                holder.tvAnimales.setTextColor(Color.BLACK)
                holder.tvAnimales.setBackgroundColor(Color.WHITE)
        }
        holder.tvAnimales.setOnClickListener{
            notifyItemChanged(clickPos)
            clickPos = position
            notifyItemChanged(clickPos)
        }
    }

}