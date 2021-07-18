package com.pulkitjndl.freechargeassignment.data.remote

import com.pulkitjndl.freechargeassignment.data.config.KEY_LIMIT
import com.pulkitjndl.freechargeassignment.data.config.KEY_SKIP
import com.pulkitjndl.freechargeassignment.data.res_model.QuotesRes
import com.pulkitjndl.freechargeassignment.data.res_model.TagsRes
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Pulkit Jindal
 * Date : 16/July/2021
 * Project : FreechargeAssignment
 */
interface ApiService {

    @GET("quotes")
    suspend fun getAllQuotes(
        @Query(KEY_LIMIT) limit: Int,
        @Query(KEY_SKIP) skip: Int,
        @Query("tags") tags: String?=null
    ): QuotesRes


    @GET("tags")
    suspend fun getAllTags(): TagsRes


}