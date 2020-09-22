package com.gok.androidapp.di

import com.gok.androidapp.asynctasks.MainAsyncTask
import com.gok.androidapp.repository.MainRepository
import com.gok.androidapp.repository.impl.MainRepositoryImpl
import com.gok.androidapp.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {

        single {
            MainRepositoryImpl()
        }

        viewModel {
          MainViewModel(
              mainRepositoryImpl = get()
          )
        }
}