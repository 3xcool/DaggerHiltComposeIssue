package com.andrefilgs.daggerhiltcomposeissue.wmservice

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.work.Operation
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.andrefilgs.daggerhiltcomposeissue.wmservice.factory.WorkRequestFactory
import com.google.common.util.concurrent.ListenableFuture
import java.util.*

/**
 * Created by andre.filgueiras on 25/11/2021.
 */

class WorkController(private val context: Context) {
  
  private val workManager = WorkManager.getInstance(context)
  
  private var notificationCounter = 0
  
  fun startCommand(notificationId: Int?=null, notificationImportance: Int?=null, allowCancel: Boolean?=true): UUID {
    val workRequest = WorkRequestFactory.buildSitefWorkerOneTime()
    workManager.let {
      it.beginWith(workRequest).enqueue()
    }
    if (notificationId == null) notificationCounter++
    return workRequest.id
  }
  
  fun getWorkManager(): WorkManager {
    return workManager
  }
  
  fun cancelAllWorks() {
    workManager.cancelAllWorkByTag(WorkRequestFactory.WORK_TAG_SITEF)
  }
  
  fun cancelWorkByTag(tag: String? = null) {
    workManager.cancelAllWorkByTag(tag ?: WorkRequestFactory.WORK_TAG_SITEF)
  }
  
  fun cancelWorkById(id: UUID): ListenableFuture<Operation.State.SUCCESS> {
    return workManager.cancelWorkById(id).result
  }
  
  
  fun getWorkInfoByLiveData(id:UUID): LiveData<WorkInfo> {
    return workManager.getWorkInfoByIdLiveData(id)
  }


}