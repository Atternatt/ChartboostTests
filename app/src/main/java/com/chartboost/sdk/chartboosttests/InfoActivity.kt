package com.chartboost.sdk.chartboosttests

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.chartboost.sdk.sdk.InitializationCallback
import com.chartboost.sdk.sdk.TestSDK
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class InfoActivity : AppCompatActivity(), InitializationCallback, CoroutineScope {

    override val coroutineContext: CoroutineContext = Job()

    val infoTv: TextView by lazy { findViewById(R.id.info) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        TestSDK.initialize(this)
    }

    override fun onInitialized() {
        launch {
            infoTv.text = TestSDK.getInfo().safe_title
        }
    }
}