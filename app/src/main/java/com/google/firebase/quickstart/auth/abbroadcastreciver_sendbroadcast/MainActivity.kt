package com.google.firebase.quickstart.auth.abbroadcastreciver_sendbroadcast

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    var receiver: BroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureReceiver()
    }
    fun broadcastIntent(view: View)
    {
        val intent = Intent()
        intent.action = "com.google.firebase.quickstart.auth.abbroadcastreciver_sendbroadcast"
        intent.flags = Intent.FLAG_INCLUDE_STOPPED_PACKAGES
        sendBroadcast(intent)
    }
    private fun configureReceiver() {
        val filter = IntentFilter()
        filter.addAction("com.google.firebase.quickstart.auth.abbroadcastreciver_sendbroadcast")
        filter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED")
        receiver = MyReceiver()
        registerReceiver(receiver, filter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }


}