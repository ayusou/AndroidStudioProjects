package com.example.recyclerapi.recycler

import android.content.Context
import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerapi.R
import com.example.recyclerapi.model.DogRespuesta

class MyAdapter(private val dataset: DogRespuesta) : RecyclerView.Adapter<MyView>() {
lateinit var myContexto: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        myContexto = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row, parent, false)

        return MyView(view)
    }

    override fun getItemCount() = dataset.message!!.size

    override fun onBindViewHolder(holder: MyView, position: Int) {
    val url: String = dataset.message!![position]
        Glide.with(myContexto).load(url).into(holder.imV1)
    }
}