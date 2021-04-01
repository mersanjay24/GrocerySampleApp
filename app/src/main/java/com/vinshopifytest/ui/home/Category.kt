package com.vinshopifytest.ui.home

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Category {
    @SerializedName("category_id")
    @Expose
    var categoryId: String = ""

    @SerializedName("category_name")
    @Expose
    var categoryName: String = ""

    @SerializedName("category_image")
    @Expose
    var categoryImage: String = ""
}