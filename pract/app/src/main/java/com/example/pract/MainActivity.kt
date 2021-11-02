package com.example.pract

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadMore()
    }

    private fun loadMore()
    {
        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.herokuapp.com/gimme"

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
        Response.Listener { response ->
            val imgUrl = response.getString("url")
//            Log.i("url", imgUrl)
            val ivMeme = findViewById<ImageView>(R.id.ivMeme)
            Glide.with(this).load(imgUrl).into(ivMeme)
        },
        Response.ErrorListener {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
        })

        queue.add(jsonObjectRequest)
    }

    fun onClickShare(view: View) {}
    fun onClickNext(view: View) {}
}