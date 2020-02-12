package com.example.lecture_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        helloTextBox.text=getString(R.string.my_string)
        var myText: TextView = bottomBox
    }

    fun clicked(view: View):Unit {
        if(view is Button){
            view.text = getString(R.string.buttonOnClick)
            var buttonCount = buttonCountText.text.toString().toInt()
            buttonCount++
            buttonCountText.text = buttonCount.toString()
        }
    }
}
