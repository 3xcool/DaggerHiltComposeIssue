package com.andrefilgs.feature1.wmservice.factory

import androidx.work.*
import com.andrefilgs.feature1.wmservice.worker.MyWorker
import com.andrefilgs.feature1.wmservice.extensions.putLDInitTime


class WorkRequestFactory {
  
  companion object{
    const val WORK_TAG_SITEF = "WORK_TAG_SITEF"
   
    
    private fun getWorkerConstraints(): Constraints {
      return Constraints.Builder()
        .setRequiredNetworkType(NetworkType.CONNECTED)
        // .setRequiresStorageNotLow(true)
        .setRequiresBatteryNotLow(true)
        .build()
    }

  
    fun buildSitefWorkerOneTime(tag: String = WORK_TAG_SITEF): OneTimeWorkRequest {
      val inputData = Data.Builder().apply {
        putLDInitTime(System.currentTimeMillis())
      }
      
      return OneTimeWorkRequest.Builder(MyWorker::class.java)
        .setConstraints(getWorkerConstraints())
        .addTag(tag)
        .setInputData(inputData.build())
        .build()
    }
  }
  
}