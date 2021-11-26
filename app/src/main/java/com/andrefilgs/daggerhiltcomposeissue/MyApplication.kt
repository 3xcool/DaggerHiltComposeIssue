package com.andrefilgs.daggerhiltcomposeissue

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

/**
 * Created by andre.filgueiras on 13/11/2021.
 */
@HiltAndroidApp
class MyApplication: Application(), Configuration.Provider {
  
  
  @Inject
  lateinit var hiltWorkerFactory: HiltWorkerFactory
  
  override fun getWorkManagerConfiguration(): Configuration {
    return Configuration.Builder()
      .setWorkerFactory(hiltWorkerFactory)
      .setMinimumLoggingLevel(android.util.Log.INFO)
      .build()
  }
}