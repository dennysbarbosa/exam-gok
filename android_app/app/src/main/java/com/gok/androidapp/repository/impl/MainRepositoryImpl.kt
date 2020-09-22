package com.gok.androidapp.repository.impl

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.gok.androidapp.GokApplication
import com.gok.androidapp.R
import com.gok.androidapp.asynctasks.MainAsyncTask
import com.gok.androidapp.models.MainModel
import com.gok.androidapp.repository.MainRepository
import retrofit2.Response

class MainRepositoryImpl(): MainRepository{

    override fun getData(): MutableLiveData<HashMap<Int, MainModel?>> {

        var response: Response<MainModel>
        val mutableLiveData: MutableLiveData<HashMap<Int, MainModel?>> = MutableLiveData()
        val hashMap: HashMap<Int, MainModel?> = HashMap()
        try {
            response = MainAsyncTask().execute().get()
            hashMap.put(response.code(), response.body())
        }catch (e: Exception){
            hashMap.put(MainAsyncTask.ERROR_GENERIC, null)
        }
        mutableLiveData.setValue(hashMap)
        return mutableLiveData
    }
}