package com.pulkitjndl.freechargeassignment.repo

import com.pulkitjndl.freechargeassignment.data.res_model.QuotesRes
import com.pulkitjndl.freechargeassignment.data.res_model.ResultData
import com.pulkitjndl.freechargeassignment.data.res_model.TagsRes

/**
 * Created by Pulkit Jindal
 * Date : 16/July/2021
 * Project : FreechargeAssignment
 */
interface AppRepository {

    suspend fun getAllQuotes(
        limit: Int,
        skip: Int,
        tags: String?=null
    ): ResultData<QuotesRes>

    suspend fun getAllTags(): ResultData<TagsRes>

}