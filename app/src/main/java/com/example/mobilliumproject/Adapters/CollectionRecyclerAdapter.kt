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

class CollectionRecyclerAdapter(val collections: List<RepoResult.Collection>) : RecyclerView.Adapter<CollectionRecyclerAdapter.CollectionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.collection_recyclerview_item, parent, false)
        return CollectionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return collections.size
    }

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {
        holder.bindItems(collections.get(position))
    }


    class CollectionViewHolder (view:View) : RecyclerView.ViewHolder(view) {
        val imageView : ImageView = view.findViewById(R.id.collection_recyclerView_cover)
        val textTitle : TextView = view.findViewById(R.id.collection_recyclerView_title)
        val textDefination : TextView = view.findViewById(R.id.collection_recyclerView_defination)

        fun bindItems(item : RepoResult.Collection){
            Picasso.get().load(item.cover?.url).resize(300,150).into(imageView)
            textTitle.setText(item.title)
            textDefination.setText(item.definition)
        }
    }
}