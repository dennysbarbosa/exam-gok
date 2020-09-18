package com.gok.androidapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gok.androidapp.R
import com.gok.androidapp.holders.ProductHolder
import com.gok.androidapp.models.ProductModel
import com.squareup.picasso.Picasso

class ProductAdapter(listProducts: List<ProductModel>): RecyclerView.Adapter<ProductHolder>(){

    var listProducts = listProducts

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductHolder(view)
    }

    override fun getItemCount(): Int {
       return listProducts.size
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {

        Picasso.get()
            .load(listProducts.get(position).imageURL)
            .error(R.mipmap.ic_launcher)
            .into(holder.imageViewBanner)
    }

}