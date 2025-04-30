package com.example.practicagambling

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.practicagambling.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    private lateinit var coroutine: Job
    lateinit var eleccionpi : ArrayAdapter<String>
    lateinit var eleccionmm : ArrayAdapter<String>
    var seleccionado =false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        eleccionpi = ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, resources.getStringArray(R.array.eleccionParImpar))
        eleccionmm = ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, resources.getStringArray(R.array.eleccionMayorMenor))

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        with(binding){

            parimpar.setOnClickListener{
                spinner.adapter=eleccionpi
                seleccionado=true
            }

            mayormenor.setOnClickListener{
                spinner.adapter=eleccionmm
                seleccionado=true
            }
            button.setOnClickListener{
                if(seleccionado) {
                    if(apuesta.text.toString() != "") {
                        var actual = spinner.selectedItem.toString();
                        if(apuesta.text.toString().toInt()>saldo.text.toString().toInt()){
                            snackbar(view,"La apuesta debe ser menor al saldo disponible", cord)
                        }
                        else {
                            var ganar=false
                            var dadonum1 = (Math.random()*6).toInt()+1
                            var dadonum2 = (Math.random()*6).toInt()+1
                            var suma = dadonum1+dadonum2
                            if (actual.equals("Par")) {
                                if(suma%2==0) ganar =true
                                else ganar=false
                            }
                            if (actual.equals("Impar")) {
                                if(suma%2==0) ganar =false
                                else ganar=true
                            }
                            if (actual.equals("Mayor o Igual que 7")) {
                                if(suma>=7) ganar =true
                                else ganar=false
                            }
                            if (actual.equals("Menor que 7")) {
                                if(suma<7) ganar =true
                                else ganar=false
                            }

                            coroutine=lifecycleScope.launch {
                                Glide.with(applicationContext).load(R.drawable.dado_imagen_animada_0092).into(imagenResul)
                                button.isEnabled=false
                                apuesta.isEnabled=false

                                delay(3000)
                                dado1.text = dadonum1.toString()
                                dado2.text = dadonum2.toString()
                                if(ganar){
                                    imagenResul.setImageResource(R.drawable.ganar_dados)
                                    saldo.text= (saldo.text.toString().toInt()+apuesta.text.toString().toInt()).toString()}
                                else{
                                    imagenResul.setImageResource(R.drawable.perder_dados)
                                    saldo.text =
                                        (saldo.text.toString().toInt() - apuesta.text.toString().toInt()).toString()
                                }
                                delay(1000)
                                if(saldo.text.toString().toInt()<=0){
                                    alertaArruinado(view)
                                    imagenResul.setImageResource(R.drawable.bancarrota)
                                }
                                else {
                                    alertaSeguirJugando(view)
                                }
                                button.isEnabled=true
                                apuesta.isEnabled=true
                            }

                        }

                    }
                    else{
                        snackbar(view,"Debe seleccionar una apuesta", cord)
                    }
                }
                else{
                    snackbar(view,"Debe seleccionar una opcion de juego", cord)
                }
            }

        }
    }
    fun snackbar(v: View, texto:String, cord: CoordinatorLayout) {
        var misnack : Snackbar
        misnack=Snackbar.make(cord,texto,Snackbar.LENGTH_SHORT)
        misnack.show()
    }
    fun alertaSeguirJugando(v:View){
        var mialerta = AlertDialog.Builder(this)
        mialerta.setTitle("Jugando a los dados")
        mialerta.setMessage("Desea seguir jugando")
        mialerta.setPositiveButton("Seguir Jugando",null)
        mialerta.setNegativeButton("Salir del Juego", {dialog, which ->
            this.finish()
        })
        mialerta.create().show()
    }
    fun alertaArruinado(v:View){
        var mialerta = AlertDialog.Builder(this)
        mialerta.setTitle("Jugando a los dados")
        mialerta.setMessage("Estas arruinado. Debes dejar el juego.")
        mialerta.setNegativeButton("Salir del Juego", {dialog, which ->
            this.finish()
        })
        mialerta.create().show()
    }

}