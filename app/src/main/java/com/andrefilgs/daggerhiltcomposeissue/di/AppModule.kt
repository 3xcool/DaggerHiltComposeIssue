package com.andrefilgs.daggerhiltcomposeissue.di

import android.content.Context
import com.andrefilgs.daggerhiltcomposeissue.wmservice.WorkController
import com.andrefilgs.daggerhiltcomposeissue.wmservice.domain.WorkerInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by andre.filgueiras on 26/11/2021.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
  
  @Provides
  @Singleton
  fun providesFeatureDomain(): WorkerInfo {
    return WorkerInfo("Feature01")
  }
  
  @Provides
  @Singleton
  fun providesWorkController(@ApplicationContext context: Context): WorkController {
    return WorkController(context)
  }
}