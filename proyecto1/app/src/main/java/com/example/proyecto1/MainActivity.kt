package com.example.proyecto1

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter

import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView

import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner

import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var mainLayout: ConstraintLayout
    lateinit var imageview: ImageView
    lateinit var spinner1:Spinner
    lateinit var spinner2:Spinner
    lateinit var animes : ArrayAdapter<String>
    lateinit var series : ArrayAdapter<String>
    lateinit var grupos : ArrayAdapter<String>

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    lateinit var amarillo:Switch
    var numaleatorio:Int =0
    @SuppressLint("MissingInflatedId", "SetTextI18n", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        spinner1 = findViewById(R.id.spinner1)
        spinner2= findViewById(R.id.spinner2)
        mainLayout = findViewById(R.id.main)
        imageview= findViewById(R.id.imageView)

        animes = ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, resources.getStringArray(R.array.spinnerAnime))
        series = ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, resources.getStringArray(R.array.spinnerSeries))
        grupos = ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, resources.getStringArray(R.array.spinnerGrupos))




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        spinner1.setOnItemSelectedListener(this)
        spinner2.setOnItemSelectedListener(this)


        }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if(parent?.id==(R.id.spinner1)) {
            if (position == 0) {
                spinner2.adapter = series
            } else if (position == 1) {
                spinner2.adapter = grupos
            } else if (position == 2) {
                spinner2.adapter = animes
            }

        }
        imageview.setImageResource(cambiar())
    }
    fun cambiar(): Int{
        var actual= spinner2.selectedItem.toString();
        if(actual.equals("Daft Punk"))
            return  R.drawable.dp
        else if(actual.equals("Scorpions"))
            return R.drawable.scorpions
        else if(actual.equals("Nirvana"))
            return R.drawable.nirvana
        else if(actual.equals("Breaking Bad"))
            return R.drawable.breakingbad
        else if(actual.equals("Friends"))
            return R.drawable.friends
        else if(actual.equals("The Big Bang Theory"))
            return R.drawable.bbt
        else if(actual.equals("Dragon Ball"))
            return R.drawable.goku
        else if(actual.equals("One Piece"))
            return R.drawable.unapieza
        else if(actual.equals("Solo Leveling"))
            return R.drawable.sololeveling
        else
            return 0
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }


}


