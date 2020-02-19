package com.example.lecture8

import android.net.Uri
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
            return URL("http://api.icndb.com/jokes/random").readText()
        }

        override fun onPostExecute(result: String?) {
            if(firstName.text.isNotBlank() && lastName.text.isNotBlank()){
              textViewMe.text =  buildCustomString()
            } else {
                super.onPostExecute(result)
                val myJson = JSONObject(result)
                val innerJson = myJson.getJSONObject("value")
                val theJoke = innerJson.getString("joke")
                textViewMe.text = theJoke
            }
        }
        private fun buildCustomString(): String {
            val buildUri= Uri.parse("http://api.icndb.com/jokes/random").buildUpon()
                .appendQueryParameter("firstName", firstName.text.toString())
                .appendQueryParameter("lastName", lastName.text.toString())
                .build()
            return buildUri.toString()
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
