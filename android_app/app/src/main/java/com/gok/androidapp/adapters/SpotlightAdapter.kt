package com.gok.androidapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gok.androidapp.R
import com.gok.androidapp.holders.SpotlightHolder
import com.gok.androidapp.models.SpotlightModel
import com.squareup.picasso.Picasso

class SpotlightAdapter(listSpotlight: List<SpotlightModel>): RecyclerView.Adapter<SpotlightHolder>(){

    var listSpotlight = listSpotlight;
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpotlightHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_spotlight, parent, false)
        return SpotlightHolder(view)
    }

    override fun getItemCount(): Int {
       return listSpotlight.size
    }

    override fun onBindViewHolder(holder: SpotlightHolder, position: Int) {

        Picasso.get().load(listSpotlight.get(position).bannerURL).into(holder.imageViewBanner)
    }

}