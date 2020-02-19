package com.example.lecture8

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    inner class myClass:AsyncTask<Void, Void, String>(){
        override fun doInBackground(vararg params: Void?): String {
            var toReturn = ""
            toReturn = URL("http://api.icndb.com/jokes/random").readText()
            return toReturn
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            val myJson = JSONObject(result)
            val innerJson = myJson.getJSONObject("value")
            val theJoke = innerJson.getJSONObject("joke")
            textViewMe.text = theJoke.toString()
        }

    }

    fun doRequest(view: View) {
        //not anonymous
        //var thread = myClass()
        //thread.execute()

        //Anonymous
        myClass().execute()
    }
}
