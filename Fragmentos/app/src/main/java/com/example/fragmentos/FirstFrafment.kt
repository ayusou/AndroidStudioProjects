package com.example.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "activityMessage"


/**
 * A simple [Fragment] subclass.
 * Use the [FirstFrafment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFrafment : Fragment() {
   private var textToShow : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            textToShow = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myview =inflater.inflate(R.layout.fragment_first_frafment, container, false)
        val mybutton = myview.findViewById<Button>(R.id.button)
        val mytv = myview.findViewById<TextView>(R.id.tv1)
        mybutton.setOnClickListener{
            mytv.text = textToShow
        }
        return myview
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFrafment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            FirstFrafment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}