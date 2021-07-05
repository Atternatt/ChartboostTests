package com.chartboost.sdk.sdk

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlin.coroutines.CoroutineContext

object TestSDK : CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Default

    suspend fun getInfo(): ApiInfo {
        var res = async {
            InfoDatasource.getInfo()
        }
        return res.await()
    }


}