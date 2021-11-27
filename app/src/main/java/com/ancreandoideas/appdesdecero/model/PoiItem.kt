package com.ancreandoideas.appdesdecero.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PoiItem(
    @SerializedName("captionDetail")
    val captionDetail: String,
    @SerializedName("descriptionDetail")
    val descriptionDetail: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("temperatureDetail")
    val temperatureDetail: String,
    @SerializedName("urlPicture")
    val urlPicture: String,
    @SerializedName("urlPictureDetail")
    val urlPictureDetail: String
):Serializable