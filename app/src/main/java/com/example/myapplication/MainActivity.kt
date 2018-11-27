package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.doAsync
import java.text.DateFormat
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "http://echo.jsontest.com/key/value/one/two"

        doAsync {
            Request(url).run()
        }

        button1.setOnClickListener {
            Toast.makeText(this, "hello world", Toast.LENGTH_SHORT).show()
        }

        val executor = Executors.newScheduledThreadPool(4)
        async(executor) {
            for (i in 1..10) {
                Thread.sleep(1000)
                Log.d("Testing", "value of I is $i")
            }
        }

        val user1 = User("Parmesh", 33)
        val (name, age) = user1

        println("Name is $name and age is $age")

        val listOfNames = listOf("Parmesh", "Kumar", "Mahore")
        val list = listOfNames.mapIndexed { index, s ->
            println("Name: $index. $s")
        }

        println("Current Date ${getDate()}")

        operators()
    }

    private fun getDate(): String {
        val df = DateFormat.getDateInstance(DateFormat.DEFAULT)
        return df.format(System.currentTimeMillis())
    }

    private fun operators() {
        val num1 = 100
        val bool = false

        println("Unary Plus ${num1.unaryPlus()}")
        println("Unary Minus ${num1.unaryMinus()}")
        println("Not ${bool.not()}")
        println("Increment ${num1.inc()}")
    }
}

data class User(val name: String, val age: Int)
