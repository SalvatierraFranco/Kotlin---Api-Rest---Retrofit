package com.example.webserviceprueba1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PostActivity : AppCompatActivity() {

    lateinit var tv_userId: TextView
    lateinit var tv_id: TextView
    lateinit var tv_title: TextView
    lateinit var tv_body: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        var postBundle = intent.extras

        setViews(postBundle)

    }

    private fun setViews(postBundle: Bundle?) {
        tv_userId = findViewById(R.id.tv_userId)
        tv_id = findViewById(R.id.tv_id)
        tv_title = findViewById(R.id.tv_title)
        tv_body = findViewById(R.id.tv_body)

        tv_userId.setText(postBundle!!.getString("userId"))
        tv_id.setText(postBundle!!.getString("id"))
        tv_title.setText(postBundle!!.getString("title"))
        tv_body.setText(postBundle!!.getString("body"))
    }
}
