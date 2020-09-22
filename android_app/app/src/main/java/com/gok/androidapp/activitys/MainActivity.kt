package com.gok.androidapp.activitys

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
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


class MainActivity : AppCompatActivity(), Observer<HashMap<Int, MainModel?>>  {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.loadData().observe(this, this);
    }

    fun initViews(mainModel: MainModel){

        val imageView = findViewById<ImageView>(R.id.image_view_cash)
        Picasso.get().load(mainModel.cashModel.bannerURL).into(imageView)

        val titleArray = mainModel.cashModel.title.split(" ")
        val textViewTitle1 = findViewById<TextView>(R.id.text_view1)
        textViewTitle1.setText(titleArray[0])

        val textViewTitle2 = findViewById<TextView>(R.id.text_view2)
        textViewTitle2.setText(titleArray[1])

        val LayoutManagerSpotlight = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val recyclerViewSpotLight = findViewById<RecyclerView>(R.id.recycle_view).apply {
            setHasFixedSize(true)
            layoutManager = LayoutManagerSpotlight
        }
        recyclerViewSpotLight.adapter = SpotlightAdapter(mainModel.listSpotlightModel)

        val LayoutManagerProduct = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val recyclerViewProduct = findViewById<RecyclerView>(R.id.recycle_view_product).apply {
            setHasFixedSize(true)
            layoutManager = LayoutManagerProduct
        }
        recyclerViewProduct.adapter = ProductAdapter(mainModel.listProductModel)
    }

    override fun onChanged(hashMap: HashMap<Int, MainModel?>) {

        val success = 200
        val mainModel = hashMap.get(success)
        if(hashMap.containsKey(success)) initViews(mainModel!!) else  Toast.makeText(this, getString(R.string.error_generic_http), Toast.LENGTH_LONG).show()
    }

}
