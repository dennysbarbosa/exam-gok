package com.gok.androidapp.asynctasks

import android.os.AsyncTask
import com.gok.androidapp.BuildConfig
import com.gok.androidapp.api.GokApi
import com.gok.androidapp.models.MainModel
import com.gok.androidapp.network.ApiConnection
import retrofit2.Response
import java.io.IOException

class MainAsyncTask: AsyncTask<Void, Void, MainModel>() {

    override fun doInBackground(vararg params: Void?): MainModel? {

        var response: Response<MainModel?>? = null
        try {
            response = ApiConnection().connection(BuildConfig.API_URL_RESOURCE).create(GokApi::class.java).getData().execute()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return response?.body()
    }


}