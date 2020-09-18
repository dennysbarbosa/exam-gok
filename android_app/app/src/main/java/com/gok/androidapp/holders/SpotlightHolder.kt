package com.gok.androidapp.holders

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.gok.androidapp.R

class SpotlightHolder(view: View) : RecyclerView.ViewHolder(view) {

    var imageViewBanner = view.findViewById<ImageView>(R.id.imageViewBanner)
}