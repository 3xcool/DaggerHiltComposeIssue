package com.andrefilgs.daggerhiltcomposeissue.screens.main

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.andrefilgs.core.domain.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by andre.filgueiras on 28/10/2021.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
val user: User
):ViewModel() {
  
  val state = mutableStateOf(user.name)

}

