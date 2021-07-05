package com.chartboost.sdk.chartboosttests

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.chartboost.sdk.sdk.TestSDK
import kotlinx.coroutines.runBlocking

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val info = runBlocking { TestSDK.getInfo() }

        val infoTv = findViewById<TextView>(R.id.info)

        infoTv.text = info.safe_title
    }
}