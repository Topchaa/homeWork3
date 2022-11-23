package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)
val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)


        val call  = serviceGenerator.getUsers()


call.enqueue(object : retrofit2.Callback<MutableList<PostModel>>{
    override fun onResponse(
        call: Call<MutableList<PostModel>>,
        response: Response<MutableList<PostModel>>
    ) {
        recyclerview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = UserAdapter(response.body()!!)

        }
    }

    override fun onFailure(call: Call<MutableList<PostModel>>, t: Throwable) {
        TODO("Not yet implemented")
    }
})



    }
}