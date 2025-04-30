package com.example.menunavegacion

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(){
    lateinit var myToolbar: MaterialToolbar
    lateinit var myMain: DrawerLayout
    lateinit var myNavigationView: NavigationView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        myToolbar = findViewById(R.id.materialToolbar)
        myMain = findViewById(R.id.main)
        myNavigationView=findViewById(R.id.myNavigation)
        setSupportActionBar(myToolbar)
// supportActionBar?.show()

        val toggle = ActionBarDrawerToggle(this, myMain, myToolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)
        myMain.addDrawerListener(toggle)
        toggle.syncState()

//        myNavigationView.setNavigationItemSelectedListener(this@MainActivity)
        myNavigationView.setNavigationItemSelectedListener {
            if (it.itemId == R.id.id_inicio){
                val myFragmentMamager: FragmentManager = supportFragmentManager
                val myFragmentTransaction : FragmentTransaction = myFragmentMamager.beginTransaction()
                    val myFragment: WebFragment= WebFragment.newInstance("https://iesclaradelrey.es/portal/index.php/es/")

                myFragmentTransaction.add(R.id.myLinearLayout, myFragment).commit()
            }
            true
        }
    }

//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        TODO("Not yet implemented")
//    }
}