package com.example.myapplication

import android.util.Log
import java.net.URL

class Request(private val url : String) {

    fun run() {
        val jsonData = URL(url).readText()
        Log.d("Request", "Json:$jsonData")
    }
}