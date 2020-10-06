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

class EditorRecyclerAdapter(val editors:List<RepoResult.ShopsEditor>,
                            val listener : EditorRecyclerViewClickListener
) : RecyclerView.Adapter<EditorRecyclerAdapter.EditorViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.editorshops_recycler_view, parent,false)
        return EditorViewHolder(view)
    }

    override fun getItemCount(): Int {
        return editors.size
    }

    override fun onBindViewHolder(holder: EditorViewHolder, position: Int) {
        holder.bindItems(editors.get(position))
        holder.itemView.setOnClickListener {
            listener.onEditorRecyclerViewItemClick(holder.itemView, editors.get(position))
        }
    }

    class EditorViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val imageView1 : ImageView = view.findViewById(R.id.editor_shop_recyclerView_Image1)
        val imageView2 : ImageView = view.findViewById(R.id.editor_shop_recyclerView_Image2)
        val imageView3 : ImageView = view.findViewById(R.id.editor_shop_recyclerView_Image3)

        val textTitle : TextView = view.findViewById(R.id.editor_shop_recyclerView_title)
        val textDefi : TextView = view.findViewById(R.id.editor_shop_recyclerView_definition)

        fun bindItems(item:RepoResult.ShopsEditor){
            Picasso.get().load(item.popular_products?.get(0)?.images?.get(0)?.url).into(imageView1)
            Picasso.get().load(item.popular_products?.get(1)?.images?.get(0)?.url).into(imageView2)
            Picasso.get().load(item.popular_products?.get(2)?.images?.get(0)?.url).into(imageView3)

            textTitle.setText(item.name)
            textDefi.setText(item.definition)
        }

    }
}