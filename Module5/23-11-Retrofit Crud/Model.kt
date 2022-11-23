package com.example.retrofitex

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Model
{
    @Expose
    @SerializedName("product_id")
    var product_id = 0

    @Expose
    @SerializedName("product_name")
    var product_name: String? = null

    @Expose
    @SerializedName("product_price")
    var product_price: String? = null

}