package com.example.memeapk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    val ivMeme = findViewById<ImageView>(R.id.ivMeme)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadMore()
    }

    private fun loadMore()
    {
        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.herokuapp.com/gimme"

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null, Response.Listener { response ->
            val img = response.getString("url")
            Glide.with(this).load(img).into(ivMeme)
        },
        Response.ErrorListener {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
        })

        queue.add(jsonObjectRequest)
    }

    fun onClickNext(view: View) {}
    fun onClickShare(view: View) {}
    fun onClickFollow(view: View) {}
}

















