package com.example.lifeciclegameplay

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.lifeciclegameplay.databinding.ActivityMainBinding
import com.example.lifeciclegameplay.model.Datos
import com.example.lifeciclegameplay.viewmodel.MainViewModel
import com.example.lifeciclegameplay.viewmodel.MainViewModelFlows
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var numclicks=0

    private val myViewModel :MainViewModelFlows by viewModels()



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


        with(binding){


//            myViewModel.datos.observe(this@MainActivity){
//                binding.textoPlano.text =it.contador.toString()
//                numclicks=it.numClicks
//                if(it.mostrarMsg){
//                    Toast.makeText(this@MainActivity,"HAS LLEGADO A 5 CLICKS",Toast.LENGTH_SHORT).show()
//                }
//            }
//
            lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED){
                    myViewModel.datos.collect{
                        textoPlano.text = it.contador.toString()
                        numclicks=it.numClicks
                        if(it.mostrarMsg){
                            Toast.makeText(this@MainActivity,"HAS LLEGADO A 5 CLICKS",Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }

            sumarBoton.setOnClickListener({
                myViewModel.sumar(binding.editText1.text.toString().toInt(),
                    Datos(binding.textoPlano.text.toString().toInt(), numclicks, false)
                )
            })
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("contador", binding.textoPlano.text.toString())
        outState.putInt("numClicks", numclicks)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        numclicks=savedInstanceState.getInt("numClicks")
        binding.textoPlano.text = savedInstanceState.getString("contador")
    }

}