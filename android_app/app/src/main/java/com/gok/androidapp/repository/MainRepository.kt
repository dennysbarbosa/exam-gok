package com.gok.androidapp.repository

import androidx.lifecycle.MutableLiveData
import com.gok.androidapp.models.MainModel

interface MainRepository {
    fun getData(): MutableLiveData<HashMap<Int, MainModel?>>
}