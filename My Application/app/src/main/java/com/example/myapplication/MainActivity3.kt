package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        var fourthbtn = findViewById<Button>(R.id.fourthbtn);
        fourthbtn.setOnClickListener {
            Intent(this,MainActivity2::class.java).also {
                finish()
            }
        }
    }
}