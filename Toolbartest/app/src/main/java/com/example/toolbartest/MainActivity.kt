package com.example.toolbartest

import android.content.Intent
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
        menuInflater.inflate(R.menu.toolbar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.vaAddCont -> Toast.makeText(this,"Want to add contact?", Toast.LENGTH_LONG).show()
            R.id.vaFav -> Toast.makeText(this,"Want to add to favorite", Toast.LENGTH_LONG).show()
            R.id.vaSettings -> Toast.makeText(this,"Modify settings", Toast.LENGTH_LONG).show()
            R.id.close -> finish()
            R.id.feedback -> Toast.makeText(this, "Feedback recorded", Toast.LENGTH_LONG).show()
        }
        return true
    }

}