package com.example.intent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Actividad2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_actividad2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var myExtra : Bundle? = intent.extras
        var myMessage = myExtra!!.getString("textoSend")
        findViewById<TextView>(R.id.textViewA2).text = myMessage


        findViewById<Button>(R.id.btnSalir).setOnClickListener{
            val myResult = Intent()
            myResult.putExtra("textoBack", findViewById<EditText>(R.id.editTextText).text.toString())
            setResult(RESULT_OK,myResult)

            this.finish()
        }
    }
}