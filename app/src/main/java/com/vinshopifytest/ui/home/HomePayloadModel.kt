package com.vinshopifytest.ui.home

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class HomePayloadModel {
    @SerializedName("access_token")
    @Expose
    var accessToken : String = ""

    @SerializedName("country_code")
    @Expose
    var countryCode : String = ""
}