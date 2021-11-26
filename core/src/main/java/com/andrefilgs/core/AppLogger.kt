package com.andrefilgs.core

import android.util.Log

/**
 * Created by andre.filgueiras on 26/11/2021.
 */
object AppLogger {
  private val TAG = "ShowMe"
  
  fun debug(msg:String){
    Log.d(TAG, msg)
  }
}