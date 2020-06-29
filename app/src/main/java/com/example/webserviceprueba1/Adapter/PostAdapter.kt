package com.example.webserviceprueba1.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.webserviceprueba1.Posts
import com.example.webserviceprueba1.R

class PostAdapter: BaseAdapter {
    var auxPosts: List<Posts>? = null

    constructor(){}

    constructor(auxPosts: List<Posts>){
        this.auxPosts = auxPosts
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val v = LayoutInflater.from(parent!!.context)
            .inflate(R.layout.item_posts, parent, false)

        var unPost = this.auxPosts!![position]

        var tv_userId = v.findViewById<TextView>(R.id.tv_userId)
        var tv_id = v.findViewById<TextView>(R.id.tv_id)
        var tv_title = v.findViewById<TextView>(R.id.tv_title)
        var tv_body = v.findViewById<TextView>(R.id.tv_body)

        tv_userId.setText(unPost.userId.toString())
        tv_id.setText(unPost.id!!.toString())
        tv_title.setText(unPost.title)
        tv_body.setText(unPost.body)

        return v
    }

    override fun getItem(position: Int): Any {
        return this.auxPosts!!.get(position)
    }

    override fun getItemId(position: Int): Long {
        return this.auxPosts!![position].id!!.toLong()
    }

    override fun getCount(): Int {
        return this.auxPosts!!.size
    }


}