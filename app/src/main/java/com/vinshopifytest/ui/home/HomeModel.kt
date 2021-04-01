package com.vinshopifytest.ui.home

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class HomeModel : Serializable {

    @SerializedName("httpcode")
    @Expose
    var httpcode: Int = 0

    @SerializedName("status")
    @Expose
    var status: String = ""

    @SerializedName("message")
    @Expose
    var message: String = ""

    @SerializedName("data")
    @Expose
    var data : Data ?= null


    class Data {
        @SerializedName("logo")
        @Expose
        var logo: String = ""

        @SerializedName("banner_slider")
        @Expose
        var bannerSlider: ArrayList<BannerSlider> ?= null

        @SerializedName("featured")
        @Expose
        var featured: ArrayList<Featured> ?= null

        @SerializedName("categories")
        @Expose
        var categories: ArrayList<Category> ?= null

        @SerializedName("regions")
        @Expose
        var regions: ArrayList<Regions> ?= null

    }

    class BannerSlider {
        @SerializedName("slider_id")
        @Expose
        var sliderId: String = ""

        @SerializedName("slider_name")
        @Expose
        var sliderName: String = ""

        @SerializedName("slider_image")
        @Expose
        var sliderImage: String = ""
    }



    class Regions{
        @SerializedName("country_id")
        @Expose
        var countryId: String = ""

        @SerializedName("country_code")
        @Expose
        var countryCode: String = ""

        @SerializedName("country_name")
        @Expose
        var countryName: String = ""
    }
}