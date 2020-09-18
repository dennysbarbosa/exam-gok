package com.gok.androidapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gok.androidapp.asynctasks.MainAsyncTask
import com.gok.androidapp.models.MainModel

class MainViewModel(mainAsyncTask: MainAsyncTask): ViewModel() {

    private var mainAsyncTask = mainAsyncTask

    fun loadData(): MutableLiveData<MainModel>? {
        val mainModelLiveData: MutableLiveData<MainModel> =
            MutableLiveData()
        try {
            val mainModel: MainModel = mainAsyncTask.execute().get()
            mainModelLiveData.setValue(mainModel)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return mainModelLiveData
    }
}