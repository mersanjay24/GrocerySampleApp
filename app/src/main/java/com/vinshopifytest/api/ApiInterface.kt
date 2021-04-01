package com.vinshopifytest.api

import com.vinshopifytest.ui.home.HomeModel
import com.vinshopifytest.ui.home.HomePayloadModel
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @POST("uat/api/home")
    fun getHomeData(@Body body: HomePayloadModel): Call<HomeModel>
}