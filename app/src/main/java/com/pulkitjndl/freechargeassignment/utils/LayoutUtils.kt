package com.pulkitjndl.freechargeassignment.utils

import android.app.Activity
import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager

/**
 * Created by Pulkit Jindal
 * Date : 18/July/2021
 * Project : FreechargeAssignment
 */

class LayoutUtils {

    companion object {

        fun getVerticalLayoutManager(activity: Activity): LinearLayoutManager {
            val layoutManager = LinearLayoutManager(activity)
            layoutManager.orientation = LinearLayoutManager.VERTICAL
            return layoutManager
        }

        fun getHorizontalLayoutManager(context: Context): LinearLayoutManager {
            val layoutManager = LinearLayoutManager(context)
            layoutManager.orientation = LinearLayoutManager.HORIZONTAL
            return layoutManager
        }
    }
}