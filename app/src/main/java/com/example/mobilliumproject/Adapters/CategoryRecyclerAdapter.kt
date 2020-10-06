package com.example.mobilliumproject.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilliumproject.Models.RepoResult
import com.example.mobilliumproject.R
import com.squareup.picasso.Picasso

class CategoryRecyclerAdapter(val categories:List<RepoResult.Category>) :
    RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_recyclerview_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bindItems(categories.get(position))
    }


    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView : ImageView = view.findViewById(R.id.category_recyclerView_cover)
        val textTitle : TextView = view.findViewById(R.id.category_recyclerView_title)

        fun bindItems(item:RepoResult.Category){
            Picasso.get().load(item.cover?.url).resize(150,150).into(imageView)
            textTitle.setText(item.name)
        }
    }
}