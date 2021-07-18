package com.pulkitjndl.freechargeassignment.data.res_model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Tags(
    @SerializedName("dateAdded")
    val dateAdded: String,
    @SerializedName("dateModified")
    val dateModified: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("quoteCount")
    val quoteCount: Int,
    @SerializedName("__v")
    val v: Int

):Serializable