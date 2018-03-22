package com.example.masrobot.myservicekotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start_service?.setOnClickListener(this)
        btn_start_intent_service?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_start_service -> {
                val mStartServiceIntent = Intent(this@MainActivity, OriginService::class.java)
                startService(mStartServiceIntent)
            }
            R.id.btn_start_intent_service -> {
                val mStartIntentService = Intent(this@MainActivity, MyIntentService::class.java)
                mStartIntentService.putExtra(MyIntentService().EXTRA_DURATION, 5000)
                startService(mStartIntentService)
            }
        }
    }
}
