package com.kalela.lifecyclescopedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            delay(5000)
            progressBar.visibility = View.VISIBLE
            delay(10000)
            progressBar.visibility = View.GONE
        }

        lifecycleScope.launchWhenCreated {
            // Will run only once when the activity/fragment is created
        }

        lifecycleScope.launchWhenStarted {
            // Will run only once when the activity/fragment is started
        }

        lifecycleScope.launchWhenResumed {
            // Will run only once when the activity/fragment is resumed
        }
    }
}