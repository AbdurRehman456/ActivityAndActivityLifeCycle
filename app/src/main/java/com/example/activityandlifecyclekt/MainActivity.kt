package com.example.activityandlifecyclekt

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

const val EXTRA_MESSAGE = "com.example.activityandlifecyclekt.MESSAGE"
class MainActivity : AppCompatActivity() {

    private var editText: EditText? = null
    private lateinit var buttonSendToast:Button
    private lateinit var buttonSendImplicit:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("MainActivity", "onCreate ........... Called")
        buttonSendToast = findViewById(R.id.openExplecit)
        buttonSendImplicit = findViewById(R.id.sendImplicit)


        buttonSendToast.setOnClickListener {
            val intentt = Intent(this,SecondActivity::class.java).apply {
                Toast.makeText(this@MainActivity,"fgvhfghf",Toast.LENGTH_SHORT).show()
            }
           startActivity(intentt)


        }

        buttonSendImplicit.setOnClickListener {
            val callIntent : Intent = Uri.parse("tel:03329819978 ").let {  number ->    // number   ?
             Intent(Intent.ACTION_DIAL,number)
            }
            startActivity(callIntent)
        }

    }


    fun sendMessage(view: View) {
        editText = findViewById(R.id.edittext)
        val message = editText!!.text.toString()

        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)

        }
        startActivity(intent)
    }

    override fun onStart() {
        Log.i("MainActivity", "onStart Called")
        super.onStart()
    }

    override fun onPause() {
        Log.i("MainActivity", "onPause Called")
        super.onPause()
    }

    override fun onRestart() {
        Log.i("MainActivity", "onRestart is Called")
        super.onRestart()
    }

    override fun onStop() {
        Log.i("MainActivity", "onStop Called")
        super.onStop()
    }

    override fun onResume() {
        Log.i("MainActivity", "onResume Called")
        super.onResume()
    }

    override fun onDestroy() {
        Log.i("MainActivity", "onDestroy Called")
        super.onDestroy()
    }


}
