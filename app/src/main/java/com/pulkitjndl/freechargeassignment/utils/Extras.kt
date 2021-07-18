package com.pulkitjndl.freechargeassignment.utils

import android.graphics.Color
import kotlin.random.Random

/**
 * Created by Pulkit Jindal
 * Date : 18/July/2021
 * Project : FreechargeAssignment
 */
class Extras {

    companion object{

        fun getRandomColor():Int{
            val rnd = Random
            return Color.argb(255, rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255))
        }
    }
}