package com.pulkitjndl.freechargeassignment.data.config

/**
 * Created by Pulkit Jindal
 * Date : 16/July/2021
 * Project : FreechargeAssignment
 */

const val IO_TIMEOUT = 30L
const val cacheSize = 10 * 1024 * 1024
const val BASE_URL="https://api.quotable.io/"

const val KEY_LIMIT = "limit"
const val KEY_SKIP = "page"

//https://api.quotable.io/quotes?limit=10&page=1
//https://api.quotable.io/authors
//https://api.quotable.io/tags
//compile 'com.github.tylersuehr7:chips-input-layout:2.3'  for tags