package com.andrefilgs.daggerhiltcomposeissue.wmservice.worker

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.media.AudioAttributes
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.hilt.work.HiltWorker
import androidx.work.*

import kotlinx.coroutines.*
import com.andrefilgs.core.AppLogger
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import com.andrefilgs.core.R
import com.andrefilgs.daggerhiltcomposeissue.wmservice.domain.WorkerInfo
import com.andrefilgs.daggerhiltcomposeissue.wmservice.extensions.getLDInitTime
import com.andrefilgs.daggerhiltcomposeissue.wmservice.extensions.putLDElapsedTime
import com.andrefilgs.daggerhiltcomposeissue.wmservice.extensions.putLDId
import com.andrefilgs.daggerhiltcomposeissue.wmservice.extensions.putLDOutputMsg

const val CHANNEL_ID_LD_DOWNLOAD = "CHANNEL_ID_LD_DOWNLOAD"

@HiltWorker
internal class MyWorker @AssistedInject constructor (
  @Assisted val context: Context,
  @Assisted parameters: WorkerParameters,
  val workerInfo: WorkerInfo
) :  CoroutineWorker(context, parameters) {
  
  private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
  
  
  @ExperimentalCoroutinesApi
  @InternalCoroutinesApi
  override suspend fun doWork(): Result = coroutineScope{
    AppLogger.debug("Initializing work...")
    val initTime = getLDInitTime()
    withContext(Dispatchers.IO){
      
      val notificationId = 1
      val allowCancel = false
      
      // Create a Notification channel if necessary
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        createChannel(CHANNEL_ID_LD_DOWNLOAD, 4)
      }
      
      val msg = "Starting Command"
      setForegroundAsync(createForegroundInfo(notificationId, msg, title="Work Mock", indeterminate = true, allowCancel =allowCancel ))
      val job = async {
        runCommand(notificationId, allowCancel=allowCancel)
      }
  
      val jobRes = job.await()
      val deltaTime = System.currentTimeMillis() - initTime
      val outputData = Data.Builder().apply {
        putLDOutputMsg("Working with success? $job after $deltaTime milliseconds")
        putLDElapsedTime(deltaTime)
      }.build()
      
      if(jobRes) Result.success(outputData)
      else Result.failure(outputData)
    }
  }
  
  

  
  @ExperimentalCoroutinesApi
  @InternalCoroutinesApi
  private suspend fun runCommand(notificationId: Int, allowCancel: Boolean): Boolean {
    for(i in 1..15){
      AppLogger.debug("Worker Running... $i")
      setForegroundAsync(createForegroundInfo(notificationId, "Progress $i", title = "Some title... ${workerInfo.title}", allowCancel = allowCancel))
      val output = Data.Builder().apply {
        putLDId("23")
      }.build()
      setProgressAsync(output)
      delay(1000L)
    }
    return true
  }
  
  
  private fun createForegroundInfo(notificationId:Int, msg:String, title:String?=null, indeterminate:Boolean?=false, allowCancel:Boolean): ForegroundInfo {
    val id = CHANNEL_ID_LD_DOWNLOAD
    val mTitle = title ?: "Some Title"
    val cancel = context.getString(R.string.cancel)
    
    val notificationBuilder = NotificationCompat.Builder(context, id)
      .setContentTitle(mTitle)
      .setTicker(mTitle)
      .setContentText(msg)
      .setSmallIcon(R.drawable.ic_android_black_24dp)
      .setOngoing(true)
      // .setProgress(100, progress, indeterminate?:false)
      .setOnlyAlertOnce(true)
      // .setAutoCancel(true)
    
    if(allowCancel){
      val intent = WorkManager.getInstance(context).createCancelPendingIntent(getId())
      notificationBuilder.apply {
        addAction(android.R.drawable.ic_delete, cancel, intent)
      }
    }
    
    return ForegroundInfo(notificationId, notificationBuilder.build())
  }
  
  
  
  @RequiresApi(Build.VERSION_CODES.O)
  private fun createChannel(id: String, notificationImportance: Int) {
    val ldDownloadChannel = NotificationChannel(id, "Downloads", notificationImportance) //NotificationManager.IMPORTANCE_MIN
  
    val attributes = AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_NOTIFICATION).build()
    
    ldDownloadChannel.apply {
      description = "LookDown download channel"
      enableLights(true)
      enableVibration(true)
      setSound(sound, attributes)
    }
    notificationManager.createNotificationChannel(ldDownloadChannel)
  }
  
  
}