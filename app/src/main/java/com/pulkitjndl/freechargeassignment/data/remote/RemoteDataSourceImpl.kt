package com.pulkitjndl.freechargeassignment.data.remote

import com.pulkitjndl.freechargeassignment.data.res_model.QuotesRes
import com.pulkitjndl.freechargeassignment.data.res_model.ResultData
import com.pulkitjndl.freechargeassignment.data.res_model.TagsRes
import com.pulkitjndl.freechargeassignment.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

/**
 * Created by Pulkit Jindal
 * Date : 16/July/2021
 * Project : FreechargeAssignment
 */
class RemoteDataSourceImpl(
    private val api: ApiService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : RemoteDataSource {


    override suspend fun getAllQuotes( limit: Int, skip: Int,tags: String?): ResultData<QuotesRes> = withContext(ioDispatcher){
        val request = api.getAllQuotes(limit, skip,tags)
        ResultData.Success(request)
    }

    override suspend fun getAllTags(): ResultData<TagsRes> = withContext(ioDispatcher){
            val request = api.getAllTags()
            ResultData.Success(request)
    }

}