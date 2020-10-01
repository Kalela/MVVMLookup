package com.kalela.workmanagerdemo1

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception

class DownloadingWorker(context: Context, params: WorkerParameters) :
    Worker(context, params) { // Pass context and params to constructor of parent class
    private val TAG = "DownloadingWorker"

    override fun doWork(): Result {
        try {
            for (i in 0..3000) {
                Log.i(TAG, "Downloading: $i")
            }

            return Result.success()
        } catch (e: Exception) {
            return Result.failure()
        }

    }
}