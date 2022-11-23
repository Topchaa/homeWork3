package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class UserAdapter(val postModel : MutableList<PostModel>) : RecyclerView.Adapter<UserViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_user,parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
     return holder.bindView(postModel[position])
    }

    override fun getItemCount(): Int {
      return postModel.size
    }


}
class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    private lateinit var context: Context
    private val name :TextView =  itemView.findViewById(R.id.firstname)
    private val image: ImageView = itemView.findViewById(R.id.img)

fun bindView(postModel: PostModel){

name.text = postModel.first_name + postModel.last_name
Glide.with(context).load(postModel.avatar).into(image)

}

}