package com.zynar.emotional_outlet.helpers

import android.util.Log
import okhttp3.*
import java.io.IOException

class ServerConnectionHelper(url: String) {
    private var serverUrl = "http://192.168.0.5:443"

    private val client: OkHttpClient = OkHttpClient()

    private var clientCallBackListener: ClientCallBackListener? = null
    fun setClientCallBackListener(clientCallBackListener: ClientCallBackListener?) {
        this.clientCallBackListener = clientCallBackListener
    }

    interface ClientCallBackListener {
        @Throws(IOException::class)
        fun onResponse(call: Call, response: Response)
    }

    init {
        serverUrl += url

        val builder = FormBody.Builder()
        val requestBody: RequestBody = builder.build()
        val request: Request =  Request.Builder()
            .url(serverUrl)
            .post(requestBody)
            .build()

        sendServer(request)
    }

    private fun sendServer(request: Request) {
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("my_emotion", e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                clientCallBackListener!!.onResponse(call, response)
            }
        })
    }

}