package com.example.recyclerapi

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerapi.databinding.ActivityMainBinding
import com.example.recyclerapi.model.MainViewModel
import com.example.recyclerapi.recycler.MyAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private  val myViewModel : MainViewModel by viewModels()
    lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        with(binding) {
            val nLayout = LinearLayoutManager(this@MainActivity)
            rvPerros.layoutManager =nLayout

            bt2.setOnClickListener{
                val raza = edt2.text.toString();
                if(raza.isEmpty()){
                    Toast.makeText(applicationContext,"Debe seleccionar una raza", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                myViewModel.devuelveFotos(raza)
            }
            myViewModel.datos.observe(this@MainActivity){
                if(it.status=="success"){
                    myAdapter=MyAdapter(it)
                    rvPerros.adapter =myAdapter
                }
                else{
                    Toast.makeText(applicationContext,"No hay fotos de esa raza", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}