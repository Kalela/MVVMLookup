package com.kalela.workmanagerdemo1

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception

class UploadWorker(context: Context, params:WorkerParameters) : Worker(context, params) { // Pass context and params to constructor of parent class
    private val TAG = "UploadWorker"
    override fun doWork(): Result {
        try {
            for (i in 0..600000) {
                Log.i(TAG, "Uploading: $i")
            }

            return Result.success()
        } catch (e : Exception) {
            return Result.failure()
        }

    }
}