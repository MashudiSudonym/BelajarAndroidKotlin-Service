package com.example.masrobot.myservicekotlin

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 *
 *
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
class MyIntentService : IntentService("MyIntentService") {

    var EXTRA_DURATION = "extra_duration"
    var TAG = "MyIntentService"

    override fun onHandleIntent(intent: Intent?) {
        Log.d(TAG, "onHandleIntent()")
        if (intent != null) {
            var duration = intent.getIntExtra(EXTRA_DURATION, 0)
            try {
                Thread.sleep(duration.toLong())
            } catch (e: InterruptedException) {
                e.printStackTrace()
                Thread.currentThread().interrupt()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy()")
    }
}
