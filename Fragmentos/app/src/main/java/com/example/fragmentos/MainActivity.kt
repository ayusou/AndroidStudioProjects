package com.example.fragmentos

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val showBtn = findViewById<Button>(R.id.showBtn)

        showBtn.setOnClickListener{
            val text = findViewById<EditText>(R.id.editTextText)
            val myFragmentManager: FragmentManager = supportFragmentManager
            val myTransactionManager : FragmentTransaction = myFragmentManager.beginTransaction()
            val myFragment: FirstFrafment = FirstFrafment.newInstance(text.text.toString())
            myTransactionManager.add(R.id.fl1, myFragment).commit()
        }
    }
}