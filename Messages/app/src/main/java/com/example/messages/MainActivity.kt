package com.example.messages

import android.content.DialogInterface
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(){

    lateinit var texto : TextView
    lateinit var cord: CoordinatorLayout
    lateinit var mivista: View
    lateinit var imagen:ImageView
    lateinit var animacion:AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        texto=findViewById(R.id.texto)
        cord=findViewById(R.id.cord)
        imagen= findViewById(R.id.gif)
        imagen.setBackgroundResource(R.drawable.tragaperras)
        animacion= imagen.background as AnimationDrawable

        //Glide.with(this).load(R.drawable.dado_imagen_animada_0092).into(imagen);
        //falta src para los dados
    }
    fun toast(v: View){
//        var mitoast : Toast
//        mitoast=Toast.makeText(this,"Tostada",Toast.LENGTH_SHORT)
//        mitoast.show()
        animacion.start()
    }
    fun barradecomer(v: View){
//        var misnack : Snackbar
//        misnack=Snackbar.make(cord,"Barra de almuerzo",Snackbar.LENGTH_SHORT).setAction("Accion",View.OnClickListener {
//            texto.text=texto.text.toString()+ "A"
//        })
//        misnack.show()
        animacion.stop()
    }
    fun alerta(v:View){
        var mialerta = AlertDialog.Builder(this)
        mialerta.setTitle("Alerta")
        mialerta.setMessage("OLA")
        mialerta.setPositiveButton("SI",DialogInterface.OnClickListener({dialog, which ->
            texto.text="MESSIRVE =)"
        }))
        mialerta.setNegativeButton("NO", {dialog, which ->
           this.finish()
        })
        mialerta.setNeutralButton("NOSE",null)
        mialerta.create().show()
    }
    fun alertaCustomizada(v:View){
        var mialerta = AlertDialog.Builder(this)
        mivista=layoutInflater.inflate(R.layout.login,null)
        mialerta.setView(mivista)
        mialerta.setTitle("Alerta")
        mialerta.setMessage("OLA")
        mialerta.setPositiveButton("SI",DialogInterface.OnClickListener({dialog, which ->
            texto.text=mivista.findViewById<EditText>(R.id.username).text
        }))
        mialerta.setNegativeButton("NO", {dialog, which ->
            this.finish()
        })
        mialerta.setNeutralButton("NOSE",null)
        mialerta.create().show()

    }

}