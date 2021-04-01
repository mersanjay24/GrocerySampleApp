package com.vinshopifytest.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vinshopifytest.api.ProjectRepository

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    
    val isLoading = MutableLiveData<Boolean>()
    val data = MutableLiveData<HomeModel>()
    val failure = MutableLiveData<String>()

    fun getHomeData() {
        var body = HomePayloadModel()
        body.accessToken = "752027"
        body.countryCode = "SA"

        ProjectRepository.getInstance().getHomeData(body, data, failure, isLoading)
    }
}