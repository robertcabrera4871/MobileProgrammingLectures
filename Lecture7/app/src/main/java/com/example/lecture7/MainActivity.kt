package com.example.lecture7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var myList = ArrayList<String>()
        myList.add("Hello")
        myList.add("Goodbye")
        myList.add("Hola")
        myList.add("Adios")

        //Anonymous Adapater
//        spinner.adapter = ArrayAdapter.createFromResource(
//            this,
//            R.array.planets_array,
//            R.layout.support_simple_spinner_dropdown_item
//        )

        var myArrayAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
            applicationContext,
            android.R.layout.simple_spinner_dropdown_item,
            myList
        )
        spinner.adapter = myArrayAdapter
        spinner.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@MainActivity,spinner.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }
}
