package com.example.activityandlifecyclekt

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private lateinit var buttonToMessage: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        // Get the Intent that started this activity and extract the string
        buttonToMessage = findViewById(R.id.sendImplicitToMessageApp)
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.textView).apply {
            text = message
        }

        buttonToMessage.setOnClickListener {
            val sendMessage = Intent()
            sendMessage.action=Intent.ACTION_SEND
            sendMessage.putExtra(Intent.EXTRA_TEXT,message)
            sendMessage.type = "text/plain"
            startActivity(sendMessage)

            }

        }
    }