package com.gok.androidapp.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gok.androidapp.R
import com.gok.androidapp.adapters.ProductAdapter
import com.gok.androidapp.adapters.SpotlightAdapter
import com.gok.androidapp.models.MainModel
import com.gok.androidapp.viewmodels.MainViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity(), Observer<MainModel>  {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.loadData()?.observe(this, this);
    }

    fun initViews(mainModel: MainModel){

        var imageView = findViewById<ImageView>(R.id.image_view_cash)
        Picasso.get().load(mainModel.cashModel.bannerURL).into(imageView)

        var titleArray = mainModel.cashModel.title.split(" ")
        var textViewTitle1 = findViewById<TextView>(R.id.text_view1)
        textViewTitle1.setText(titleArray[0])

        var textViewTitle2 = findViewById<TextView>(R.id.text_view2)
        textViewTitle2.setText(titleArray[1])

        var LayoutManagerSpotlight = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        var recyclerViewSpotLight = findViewById<RecyclerView>(R.id.recycle_view).apply {
            setHasFixedSize(true)
            layoutManager = LayoutManagerSpotlight
        }
        recyclerViewSpotLight.adapter = SpotlightAdapter(mainModel.listSpotlightModel)

        var LayoutManagerProduct = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        var recyclerViewProduct = findViewById<RecyclerView>(R.id.recycle_view_product).apply {
            setHasFixedSize(true)
            layoutManager = LayoutManagerProduct
        }
        recyclerViewProduct.adapter = ProductAdapter(mainModel.listProductModel)
    }

    override fun onChanged(mainModel: MainModel) {

        Log.d("teste", "teste")
        initViews(mainModel)
    }

}
