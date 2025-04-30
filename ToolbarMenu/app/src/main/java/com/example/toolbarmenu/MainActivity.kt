package com.example.toolbarmenu

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {
    lateinit var imageViewMorfeo : ImageView
    lateinit var tvMorfeo : TextView
    lateinit var toolbar : MaterialToolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        imageViewMorfeo = findViewById(R.id.imageView)
        tvMorfeo = findViewById(R.id.tV2)
        toolbar  = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)
        supportActionBar?.hide()
        imageViewMorfeo.setOnClickListener{
            supportActionBar!!.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.firstmenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.bluePasti){
            tvMorfeo.setText("Asul")
        }
        if(item.itemId == R.id.redPasti){
            tvMorfeo.setText("ROjos")
        }
        if(item.itemId == R.id.exit){
           this.finish()
        }



        return super.onOptionsItemSelected(item)
    }
}