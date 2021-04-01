package com.vinshopifytest.api

import androidx.lifecycle.MutableLiveData
import com.vinshopifytest.ui.home.HomeModel
import com.vinshopifytest.ui.home.HomePayloadModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProjectRepository {
    private var apiInterface: ApiInterface = ApiClient.client.create(ApiInterface::class.java)

    companion object {
        private var sInstance: ProjectRepository? = null

        @Synchronized
        fun getInstance(): ProjectRepository {
            if (sInstance == null) {
                if (sInstance == null) {
                    sInstance = ProjectRepository()
                }
            }
            return sInstance!!
        }
    }

    fun getHomeData(
        body: HomePayloadModel,
        data: MutableLiveData<HomeModel>,
        error: MutableLiveData<String>,
        isLoading: MutableLiveData<Boolean>
    ) {

        isLoading.value = true
        apiInterface.getHomeData(body).enqueue(object : Callback<HomeModel> {
            override fun onResponse(
                call: Call<HomeModel>,
                response: Response<HomeModel>
            ) {
                if (response.isSuccessful) {
                    data.value = response.body()
                } else {
                    error.value = "Something is wrong.."
                }
                isLoading.value = false
            }

            override fun onFailure(call: Call<HomeModel>, t: Throwable) {
                isLoading.value = false
                error.value = "Something is wrong.."
            }
        })
    }
}