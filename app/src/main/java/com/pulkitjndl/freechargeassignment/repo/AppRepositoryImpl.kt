package com.pulkitjndl.freechargeassignment.repo

import com.pulkitjndl.freechargeassignment.data.remote.RemoteDataSource
import com.pulkitjndl.freechargeassignment.data.res_model.QuotesRes
import com.pulkitjndl.freechargeassignment.data.res_model.RemoteDataNotFoundException
import com.pulkitjndl.freechargeassignment.data.res_model.ResultData
import com.pulkitjndl.freechargeassignment.data.res_model.TagsRes
import com.pulkitjndl.freechargeassignment.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Created by Pulkit Jindal
 * Date : 16/July/2021
 * Project : FreechargeAssignment
 */
class AppRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : AppRepository {


    override suspend fun getAllQuotes(limit: Int, skip: Int,tags: String?): ResultData<QuotesRes> {
        return when (val result =
                remoteDataSource.getAllQuotes(limit, skip,tags)) {
            is ResultData.Success -> {
                val response = result.data
                //withContext(ioDispatcher) { appDao.setListCountries(response) }
                ResultData.Success(response)
            }
            is ResultData.Error -> {
                ResultData.Error(RemoteDataNotFoundException())
            }
        }
    }

    override suspend fun getAllTags(): ResultData<TagsRes> {
        return when (val result =
            remoteDataSource.getAllTags()) {
            is ResultData.Success -> {
                val response = result.data
                //withContext(ioDispatcher) { appDao.setListCountries(response) }
                ResultData.Success(response)
            }
            is ResultData.Error -> {
                ResultData.Error(RemoteDataNotFoundException())
            }
        }
    }

}