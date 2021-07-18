package com.pulkitjndl.freechargeassignment.data.res_model

/**
 * Created by Pulkit Jindal
 * Date : 18/July/2021
 * Project : FreechargeAssignment
 */

sealed class ResultData<out T : Any> {
    data class Success<out T : Any>(val data: T) : ResultData<T>()
    data class Error(val exception: Exception) : ResultData<Nothing>()
}