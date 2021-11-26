package com.andrefilgs.feature1.wmservice.extensions

import androidx.work.Data
import androidx.work.ListenableWorker

const val LD_KEY_ID="LD_KEY_ID"
const val LD_KEY_TITLE="LD_KEY_TITLE"
const val LD_KEY_INIT_TIME="LD_KEY_INIT_TIME"
const val LD_KEY_ELAPSED_TIME="LD_KEY_ELAPSED_TIME"
const val LD_KEY_OUTPUT_MSG="LD_KEY_OUTPUT_MSG"


fun ListenableWorker.getLDInitTime() = this.inputData.getLong(LD_KEY_INIT_TIME, -1)


//WorkManager have a limit of 10240KB
fun Data.Builder.putLDId(value: String) = this.putString(LD_KEY_ID, value)
fun Data.Builder.putLDTitle(value: String?) = this.putString(LD_KEY_TITLE, value)
fun Data.Builder.putLDInitTime(value: Long) = this.putLong(LD_KEY_INIT_TIME, value)
fun Data.Builder.putLDElapsedTime(value: Long) = this.putLong(LD_KEY_ELAPSED_TIME, value)
fun Data.Builder.putLDOutputMsg(value: String) = this.putString(LD_KEY_OUTPUT_MSG, value)

