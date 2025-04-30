package com.example.practicarecycleview1colorines.recycler

import android.graphics.Color
import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practicarecycleview1colorines.MyColor
import com.example.practicarecycleview1colorines.R

class MyAdapter(private val dataset: List<MyColor>):RecyclerView.Adapter<MyView>() {
    var clickPos: Int=RecyclerView.NO_POSITION
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)
        return MyView(view)
    }

    override fun getItemCount()= dataset.size

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.tvColores.text =dataset[position].name
        holder.textoCod.text = dataset[position].code
        holder.fondo.setBackgroundColor(Color.parseColor(dataset[position].code))
            if(position == clickPos){

                holder.tvColores.setTextColor(Color.parseColor(dataset[position].code))
                holder.tvColores.setBackgroundColor(Color.WHITE)

            }
            else{
                holder.tvColores.setTextColor(Color.WHITE)
                holder.tvColores.setBackgroundColor(Color.parseColor(dataset[position].code))
            }
            holder.tvColores.setOnClickListener{
                notifyItemChanged(clickPos)
                clickPos = position
                notifyItemChanged(clickPos)
            }
            holder.textoCod.setOnClickListener{
            notifyItemChanged(clickPos)
            clickPos = position
            notifyItemChanged(clickPos)
        }
        holder.tvColores.setOnLongClickListener(){
            notifyItemChanged(clickPos)
            clickPos = RecyclerView.NO_POSITION
            notifyItemChanged(clickPos)
        return@setOnLongClickListener true
        }
        holder.textoCod.setOnLongClickListener(){
            notifyItemChanged(clickPos)
            clickPos = RecyclerView.NO_POSITION
            notifyItemChanged(clickPos)
            return@setOnLongClickListener true
        }
        }
    }

