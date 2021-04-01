package com.vinshopifytest.ui.home

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Featured {
    @SerializedName("prd_id")
    @Expose
    var prdId: String = ""

    @SerializedName("prd_name")
    @Expose
    var prdName: String = ""

    @SerializedName("prd_image")
    @Expose
    var prdImage: String = ""

    @SerializedName("qty")
    @Expose
    var qty: String = ""

    @SerializedName("unit")
    @Expose
    var unit: String = ""

    @SerializedName("current_stock")
    @Expose
    var currentStock: String = ""

    @SerializedName("price")
    @Expose
    var price: String = ""

    @SerializedName("currency")
    @Expose
    var currency: String = ""

    @SerializedName("rating")
    @Expose
    var rating: String = ""

    fun getPriceWithSymbol() : String{
        return "$price $currency"
    }

    fun getStickAndUnity() : String{
        return "$currentStock $unit"
    }

    fun isOutOfStock() : Boolean{

        if(currentStock.isNullOrEmpty())
            return true;

        var stock = currentStock.toInt()

        if(stock <= 0)
            return true

        return false
    }

    fun getRatingFloat() : Float{
        if(rating.isNullOrEmpty())
            return 0f

        return rating.toFloat()

    }
}