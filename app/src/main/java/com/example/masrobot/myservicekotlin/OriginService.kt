package com.example.masrobot.myservicekotlin

import android.app.Service
import android.content.Intent
import android.os.AsyncTask
import android.os.IBinder
import android.util.Log

class OriginService : Service() {

    val ORIGIN_SERVICE = "OriginService"

    override fun onBind(intent: Intent): IBinder? {
        // TODO: Return the communication channel to the service.
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(ORIGIN_SERVICE, "OriginService dijalankan")

        val mProcessAsync = ProcessAsync()
        mProcessAsync.execute()
        return START_STICKY
    }

    private inner class ProcessAsync: AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg params: Void?): Void? {
            try {
                Thread.sleep(3000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

            return null
        }

        override fun onPostExecute(aVoid: Void?) {
            super.onPostExecute(aVoid)
            Log.d(ORIGIN_SERVICE, "StopService")
            stopSelf()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(ORIGIN_SERVICE, "onDestroy()")
    }

}
