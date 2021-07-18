package com.pulkitjndl.freechargeassignment.data.res_model


import com.google.gson.annotations.SerializedName
import com.pulkitjndl.freechargeassignment.model.Quote
import java.io.Serializable

data class QuotesRes(
        @SerializedName("count")
    val count: Int,
        @SerializedName("lastItemIndex")
    val lastItemIndex: Int,
        @SerializedName("page")
    val page: Int,
        @SerializedName("results")
    val results: List<Quote>,
        @SerializedName("totalCount")
    val totalCount: Int,
        @SerializedName("totalPages")
    val totalPages: Int
):Serializable