package com.gok.androidapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gok.androidapp.models.MainModel
import com.gok.androidapp.repository.impl.MainRepositoryImpl

class MainViewModel(mainRepositoryImpl: MainRepositoryImpl): ViewModel() {

    private var mainRepositoryImpl = mainRepositoryImpl

    fun loadData(): MutableLiveData<HashMap<Int, MainModel?>> {

        var mutableLiveData = mainRepositoryImpl.getData()
        return mutableLiveData
    }
}