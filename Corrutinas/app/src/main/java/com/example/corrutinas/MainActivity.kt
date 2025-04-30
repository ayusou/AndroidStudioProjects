package com.example.corrutinas

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.corrutinas.databinding.ActivityMainBinding
import kotlinx.coroutines.AbstractCoroutine
import kotlinx.coroutines.Delay
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    lateinit var binding : ActivityMainBinding
    private lateinit var coroutine: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        with(binding){
            btConHilos.setOnClickListener{
                btConHilos.isEnabled=false
                coroutine=lifecycleScope.launch {
                    pB1.max=100
                    pB1.setProgress(0)
                    for(i in 1..10){
                        tareaLarga2()
                        pB1.progress=i*10
                    }
                    tareaFin(view)
                    myTV.text = "Tarea Finalizada"
                    btConHilos.isEnabled=true
                }
                myTV.text="en progreso"

            }
            btStop.setOnClickListener{
                coroutine.cancel()
                myTV.text= "Cancelado"
                btConHilos.isEnabled=true
            }
            btSinHilos.setOnClickListener({
                pB1.max=100
                pB1.setProgress(0)
                for(i in 1..10){
                    tareaLarga()
                    pB1.progress=i*10
                }
                tareaFin(view)
                myTV.text = "Tarea Finalizada"
            })
        }
    }
    fun tareaFin(v: View){
        var mitoast : Toast
        mitoast=Toast.makeText(this,"Tarea Finalizada",Toast.LENGTH_SHORT)
        mitoast.show()
    }
    fun decirHola(v: View){
        var mitoast : Toast
        mitoast=Toast.makeText(this,"Hola",Toast.LENGTH_SHORT)
        mitoast.show()
    }
    fun tareaLarga(){
        Thread.sleep(1000)
    }

    suspend fun tareaLarga2(){
        delay(1000)
    }
}