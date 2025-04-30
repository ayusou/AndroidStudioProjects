package com.example.practicarecycleview1colorines.recycler

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicarecycleview1colorines.R

public class MyView(itemView: View): RecyclerView.ViewHolder(itemView){
    val tvColores : TextView = itemView.findViewById(R.id.texto1)
    val fondo : LinearLayout = itemView.findViewById(R.id.fondo)
    val textoCod : TextView = itemView.findViewById(R.id.texto2)
}
