package com.example.mobilliumproject.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilliumproject.InterfaceHelper.EditorRecyclerViewClickListener
import com.example.mobilliumproject.Models.RepoResult
import com.example.mobilliumproject.R
import com.squareup.picasso.Picasso

class NewShopsRecyclerAdapter (val newShops : List<RepoResult.ShopsEditor>,
                               val listener : EditorRecyclerViewClickListener
) :
    RecyclerView.Adapter<NewShopsRecyclerAdapter.NewShopsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewShopsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.newshops_recyclerciew_item, parent, false)
        return NewShopsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newShops.size
    }

    override fun onBindViewHolder(holder: NewShopsViewHolder, position: Int) {
        holder.bindItems(newShops.get(position))
        holder.itemView.setOnClickListener {
            listener.onNewShopRecyclerViewItemClick(holder.itemView, newShops.get(position))
        }
    }

    class NewShopsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView : (ImageView) = view.findViewById(R.id.new_shops_recyclerView_ImageView)
        val textTitle : (TextView) = view.findViewById(R.id.new_shops_recyclerView_Title)
        val textDefinition : (TextView) = view.findViewById(R.id.new_shops_recyclerView_definition)

        fun bindItems(item : RepoResult.ShopsEditor){
            Picasso.get().load(item.cover?.url).into(imageView)
            textTitle.setText(item.name)
            textDefinition.setText(item.definition)
        }
    }
}