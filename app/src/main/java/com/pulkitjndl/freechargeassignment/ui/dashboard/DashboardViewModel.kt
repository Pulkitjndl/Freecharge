package com.pulkitjndl.freechargeassignment.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pulkitjndl.freechargeassignment.data.res_model.QuotesRes
import com.pulkitjndl.freechargeassignment.data.res_model.ResultData
import com.pulkitjndl.freechargeassignment.data.res_model.TagsRes
import com.pulkitjndl.freechargeassignment.repo.AppRepositoryImpl
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Pulkit Jindal
 * Date : 18/July/2021
 * Project : FreechargeAssignment
 */
class DashboardViewModel @Inject constructor(
    private val repositoryImpl: AppRepositoryImpl
) :
    ViewModel() {


    private var _resultAllQuotes = MutableLiveData<QuotesRes>()
    var resultAllQuotes : LiveData<QuotesRes> = _resultAllQuotes

    private var _errorAllQuotes = MutableLiveData<String>()
    var errortAllQuotes : LiveData<String> = _errorAllQuotes

    private var _loadingAllQuotes = MutableLiveData<Boolean>()
    var loadingAllQuotes : LiveData<Boolean> = _loadingAllQuotes

    fun getAllQuotes(limit: Int,skip: Int,tags: String?=null)
    {
        _loadingAllQuotes.postValue(true)
        viewModelScope.launch {
            try {
                when (val response = repositoryImpl.getAllQuotes(limit,skip,tags)) {
                    is ResultData.Success -> {
                        _loadingAllQuotes.postValue(false)
                        _resultAllQuotes.postValue(response.data)
                    }
                    is ResultData.Error -> {
                        _loadingAllQuotes.postValue(false)
                        _errorAllQuotes.postValue(response.exception.toString())
                    }
                }
            } catch (e: Exception) {
                _loadingAllQuotes.postValue(false)
                _errorAllQuotes.postValue(e.message)
            }
        }
    }

    //Get All Tags
    private var _resultAllTags = MutableLiveData<TagsRes>()
    var resultAllTags : LiveData<TagsRes> = _resultAllTags

    private var _errorAllTags = MutableLiveData<String>()
    var errortAllTags : LiveData<String> = _errorAllTags

    private var _loadingAllTags = MutableLiveData<Boolean>()
    var loadingAllTags: LiveData<Boolean> = _loadingAllTags

    fun getAllTags()
    {
        _loadingAllTags.postValue(true)
        viewModelScope.launch {
            try {
                when (val response = repositoryImpl.getAllTags()) {
                    is ResultData.Success -> {
                        _loadingAllTags.postValue(false)
                        _resultAllTags.postValue(response.data)
                    }
                    is ResultData.Error -> {
                        _loadingAllTags.postValue(false)
                        _errorAllTags.postValue(response.exception.toString())
                    }
                }
            } catch (e: Exception) {
                _loadingAllTags.postValue(false)
                _errorAllTags.postValue(e.message)
            }
        }
    }


}