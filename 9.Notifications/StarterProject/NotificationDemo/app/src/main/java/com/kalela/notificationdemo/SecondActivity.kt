package com.kalela.notificationdemo

import android.app.NotificationManager
import android.app.RemoteInput
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        recieveInput()
    }

    private fun recieveInput() {
        val KEY_REPLY = "key_reply";
        val channelId = "com.kalela.notificationdemo.channel1"
        val notificationId = 45

        val intent = this.intent
        val remoteInput = RemoteInput.getResultsFromIntent(intent)

        if (remoteInput != null) {
            val inputString = remoteInput.getCharSequence(KEY_REPLY).toString()
            result_text_view.text = inputString
        }

        val repliedNotification = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentText("Your reply recieved")
            .build()

        val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.notify(notificationId, repliedNotification)
    }
}