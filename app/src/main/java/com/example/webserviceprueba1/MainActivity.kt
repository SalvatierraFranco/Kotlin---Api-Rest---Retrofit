package com.example.webserviceprueba1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.example.webserviceprueba1.Adapter.PostAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var api: MyApi? = null
    lateinit var adapter: PostAdapter
    lateinit var lv_Posts: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializerApi()
        callGetPosts()
    }

    private fun visualizarPost(postsList: List<Posts>) {
        lv_Posts = findViewById(R.id.lv_posts)
        lv_Posts.setOnItemClickListener { parent, view, position, id ->
            goToPost(postsList.get(position))
        }
    }

    private fun goToPost(unPost: Posts) {
        var postIntent = Intent(applicationContext, PostActivity::class.java).apply {
            putExtra("userId", unPost.userId.toString())
            putExtra("id", unPost.id.toString())
            putExtra("title", unPost.title)
            putExtra("body", unPost.body)
        }
        startActivity(postIntent)
    }

    private fun initializerApi() {
        api = RetrofitClient.retrofit.create(MyApi::class.java)
    }

    private fun callGetPosts(){
        val callGetPosts = api?.getPosts()
        callGetPosts?.enqueue(object : Callback<List<Posts>>{
            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                lv_Posts = findViewById(R.id.lv_posts)
                var postsList: List<Posts>? = response.body()
                adapter = PostAdapter(postsList!!)
                lv_Posts.adapter = adapter

                visualizarPost(postsList!!)

                /*for (i in postsList!!.indices){
                    var cadena = ""

                    cadena += "userId: " + postsList[i].userId
                    cadena += "\nid: " + postsList[i].id
                    cadena += "\ntitle: " + postsList[i].title
                    cadena += "\nbody: " + postsList[i].body + "\n\n"

                    jsonText.append(cadena)
                }*/

            }
        })
    }
}
