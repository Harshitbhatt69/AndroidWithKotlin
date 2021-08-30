package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var firstbtn = findViewById<Button>(R.id.firstbtn)
        firstbtn.setOnClickListener {
            Intent(this,MainActivity2::class.java).also {
                startActivity(it)
            }
        }

    }
}