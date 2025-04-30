package com.example.practicarecycleview1colorines

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practicarecycleview1colorines.databinding.ActivityMainBinding
import com.example.practicarecycleview1colorines.recycler.MyAdapter
import com.example.recycleview.model.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private  val myViewModel : MainViewModel by viewModels()
    lateinit var myAdapter: MyAdapter

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
            myViewModel.devuelveArray()
            val myLayout = LinearLayoutManager(this@MainActivity)
            rvColores.layoutManager =myLayout

            myViewModel.datos.observe(this@MainActivity){
                myAdapter = MyAdapter (it)
                rvColores.adapter =myAdapter
                val midividerItemDecoration = DividerItemDecoration(rvColores.getContext(),
                    myLayout.orientation)
            }
            myViewModel.borrar.observe(this@MainActivity){
                myAdapter.notifyItemRemoved(it.position)
                myAdapter.clickPos = RecyclerView.NO_POSITION
                myAdapter.notifyItemRangeChanged(0,it.colores.size)
            }
            delBtn.setOnClickListener{
                if(myAdapter.clickPos<0){
                    Toast.makeText(applicationContext,"Debe seleccionar una fila", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                myViewModel.borrar(myAdapter.clickPos)

            }
            myViewModel.aniadir.observe(this@MainActivity){
                myAdapter.notifyItemInserted(it.position)
                myAdapter.notifyItemRangeChanged(0,it.colores.size)
            }
            addBtn.setOnClickListener{
                var position = myAdapter.clickPos+1
                if(position<0){
                    position=0
                }
                myViewModel.aniadir(position,editText.text.toString(), editText2.text.toString())
            }

        }
    }
}