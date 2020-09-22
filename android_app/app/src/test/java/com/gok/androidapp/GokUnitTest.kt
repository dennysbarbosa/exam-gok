package com.gok.androidapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.gok.androidapp.repository.impl.MainRepositoryImpl
import com.gok.androidapp.viewmodels.MainViewModel
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test


class GokUnitTest {

    @get: Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun validObject() {
        val mainRepositoryImpl = MainRepositoryImpl()
        val mainViewModel = MainViewModel(mainRepositoryImpl)

        assertNotNull(mainViewModel.loadData())
    }

}


