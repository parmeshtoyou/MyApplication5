package com.example.myapplication

class SomeClass {

    fun doSomeWork(onClick : (String) -> Unit) {
        for (i in 1..5) {
            Thread.sleep(500)
        }
        onClick.invoke("Hello World")
    }
}