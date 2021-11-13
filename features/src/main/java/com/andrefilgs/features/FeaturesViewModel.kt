package com.andrefilgs.features

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.andrefilgs.core.domain.User
import com.andrefilgs.core.domain.User2
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by andre.filgueiras on 28/10/2021.
 */
@HiltViewModel
class FeaturesViewModel @Inject constructor(
val user: User,
val user2: User2
):ViewModel() {
  
  val state = mutableStateOf(user.name)
  // val state = mutableStateOf("Mock")

}

