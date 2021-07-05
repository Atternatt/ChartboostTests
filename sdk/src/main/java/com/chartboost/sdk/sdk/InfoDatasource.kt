package com.chartboost.sdk.sdk

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

object InfoDatasource {

    private val okHttpClient: OkHttpClient = OkHttpClient()

    suspend fun getInfo(): ApiInfo {
        val request = Request.Builder()
            .url("https://xkcd.com/info.0.json")
            .get()
            .build()
        return okHttpClient.newCall(request).execute().let { it.body!! }.let {
            val info: ApiInfo = Gson().fromJson(it.string(), ApiInfo::class.java)
            info
        }
    }
}