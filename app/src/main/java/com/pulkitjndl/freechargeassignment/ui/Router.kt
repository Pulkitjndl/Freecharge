package com.pulkitjndl.freechargeassignment.ui

import android.app.Activity
import android.content.Intent
import com.pulkitjndl.freechargeassignment.model.Quote
import com.pulkitjndl.freechargeassignment.ui.detail.DetailActivity
import javax.inject.Singleton

/**
 * Created by Pulkit Jindal
 * Date : 16/July/2021
 * Project : FreechargeAssignment
 */

@Singleton
class Router {


    val QUOTE_DATA="QUOTE_DATA"

    fun showQuoteDetailPage(sourceActivity: Activity, quote: Quote) {
        val intent = Intent(sourceActivity, DetailActivity::class.java)
        intent.putExtra(QUOTE_DATA, quote)
        sourceActivity.startActivity(intent)
    }

}