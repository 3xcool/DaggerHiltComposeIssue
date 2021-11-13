package com.andrefilgs.core.di

import com.andrefilgs.core.domain.User
import com.andrefilgs.core.domain.User2
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by andre.filgueiras on 13/11/2021.
 */

@Module
@InstallIn(SingletonComponent::class)
object UserModule {
  
  @Provides
  @Singleton
  fun providesUser(): User {
    return User(name = "Filgs")
  }
  
  
  @Provides
  @Singleton
  fun providesUser2(): User2 {
    return User2(name = "Filgs 2")
  }
}