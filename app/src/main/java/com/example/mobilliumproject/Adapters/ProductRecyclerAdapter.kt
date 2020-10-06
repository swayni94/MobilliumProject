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


class ProductRecyclerAdapter(val products:List<RepoResult.Product>) : RecyclerView.Adapter<ProductRecyclerAdapter.ProductViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_recyclerview_item, parent, false)
        return ProductViewHolder(view)
    }


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bindItems(products.get(position))

    }

    override fun getItemCount(): Int {
        return products.size
    }

    class ProductViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val imageViewProduct : ImageView =view.findViewById(R.id.product_item_ImageView)
        val titleProduct : TextView = view.findViewById(R.id.product_item_title)
        val shopName : TextView = view.findViewById(R.id.product_item_ShopName)

        fun bindItems(item: RepoResult.Product){
            val thumbnail= item.images!![0].thumbnail!!
            Picasso.get().load(thumbnail.url).resize(200, 200).into(imageViewProduct)
            titleProduct.setText(item.title)
            shopName.setText(item.shop?.name)
        }

    }
}