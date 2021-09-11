package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var secondbtn = findViewById<Button>(R.id.secondbtn)
        secondbtn.setOnClickListener {
            finish()
        }
        var thirdbtn = findViewById<Button>(R.id.thirdbtn)
        thirdbtn.setOnClickListener {
            Intent(this,MainActivity3::class.java).also {
                startActivity(it)
            }
        }
    }
}