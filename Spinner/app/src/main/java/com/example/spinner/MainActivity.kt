package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spMonth = findViewById<Spinner>(R.id.spMonth)

        val customList = listOf("First","Second","Third","Fourth")
        val adapter = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,customList)
        spMonth.adapter = adapter


        spMonth.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@MainActivity,
                    "${parent?.getItemAtPosition(position).toString()}",
                    Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {   //if nothing selected. Simply IDC

            }
        }
    }
}