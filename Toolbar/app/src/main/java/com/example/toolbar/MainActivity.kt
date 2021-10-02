package com.example.toolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.miAddContact -> Toast.makeText(this,"You have clicked in Add Contact icon", Toast.LENGTH_LONG).show()
            R.id.miFavorite -> Toast.makeText(this,"You have clicked in Favorite option", Toast.LENGTH_LONG).show()
            R.id.miFeedback -> Toast.makeText(this, "You want to give feedback?", Toast.LENGTH_LONG).show()
            R.id.miSettings -> Toast.makeText(this, "You have clicked in settings", Toast.LENGTH_LONG).show()
            R.id.miClose -> finish()
        }
        return true
    }
}