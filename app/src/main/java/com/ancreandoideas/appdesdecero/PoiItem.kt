package com.ancreandoideas.appdesdecero


import com.google.gson.annotations.SerializedName

data class PoiItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("urlPicture")
    val urlPicture: String
)