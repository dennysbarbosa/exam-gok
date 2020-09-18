package com.gok.androidapp.di

import com.gok.androidapp.asynctasks.MainAsyncTask
import com.gok.androidapp.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {

        single {
            MainAsyncTask()
        }

        viewModel {
          MainViewModel(
              mainAsyncTask = get()
          )
        }
}