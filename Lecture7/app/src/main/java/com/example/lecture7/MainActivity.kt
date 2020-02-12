package com.example.lecture7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        var myList = ArrayList<String>();
//        myList.add("Hello");
//        myList.add("Goodbye");
//        myList.add("Hola");
//        myList.add("Adios");
        spinner.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.planets_array,
            
        )

    }
}
