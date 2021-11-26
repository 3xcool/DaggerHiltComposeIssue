package com.andrefilgs.feature1

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.andrefilgs.core.AppLogger
import com.andrefilgs.core.domain.User
import com.andrefilgs.feature1.wmservice.WorkController
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject

/**
 * Created by andre.filgueiras on 28/10/2021.
 */
@HiltViewModel
class Feature1ViewModel @Inject constructor(
val user: User,
val workController: WorkController
):ViewModel() {
  
  val state = mutableStateOf(user.name)
  // val state = mutableStateOf("Mock")

  var workId:UUID?=null
  
  fun runWork(){
    workId = workController.startCommand()
    AppLogger.debug("WorkId: $workId")
  }
  
  fun stopWork(){
    workId?.let{
      workController.cancelWorkById(it)
    }
  }
}

