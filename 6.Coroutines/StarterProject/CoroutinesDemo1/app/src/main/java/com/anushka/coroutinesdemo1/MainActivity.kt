package com.anushka.coroutinesdemo1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCount.setOnClickListener {
            tvCount.text = count++.toString()
        }
        btnDownloadUserData.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
//                tvUserMessage.text = UserDataManager1().getTotalUserCount().toString()
                tvUserMessage.text = UserDataManager2().getTotalUserCount().toString()
            }

        }
    }

    @SuppressLint("SetTextI18n")
    private suspend fun downloadUserData() {
        withContext(Dispatchers.Main) {
            for (i in 1..200000) {

                tvUserMessage.text = "Downloading user $i in ${Thread.currentThread().name}";
                delay(100)
            }

        }
    }
}
