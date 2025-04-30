package com.example.recycleview.recycler

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.R

public class MyView(itemView: View): RecyclerView.ViewHolder(itemView){
    val tvAnimales : TextView = itemView.findViewById(R.id.texto1)
}
