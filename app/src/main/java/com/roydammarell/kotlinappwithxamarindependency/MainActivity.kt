package com.roydammarell.kotlinappwithxamarindependency

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.roydammarell.xamarin.HelloService

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val helloView = findViewById<TextView>(R.id.helloView)
        helloView.text = helloService.createHello()
    }

    private val helloService = HelloService()
}
