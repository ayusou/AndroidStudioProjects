package com.example.intent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    lateinit var myActivityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<Button>(R.id.Btn1).setOnClickListener{
            var myIntent : Intent = Intent(this, Actividad2::class.java)
            myIntent.putExtra("textoSend",findViewById<EditText>(R.id.myEditText).text.toString())
//            startActivity(myIntent)
            myActivityResultLauncher.launch(myIntent)
        }

        myActivityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
            result : ActivityResult? ->
            if(result!!.resultCode == Activity.RESULT_OK){
                val myIntentResult= result.data
                findViewById<TextView>(R.id.textView2).text = myIntentResult!!.extras!!.getString("textoBack")
            }
            else{
                Toast.makeText(this, "Ha fallado", Toast.LENGTH_SHORT).show()
            }
        }
    }
}