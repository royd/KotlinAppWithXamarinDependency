package com.roydammarell.kotlinappwithxamarindependency

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.roydammarell.xamarin.ServiceFactory
import com.roydammarell.xamarininterface.IExceptionService
import com.roydammarell.xamarininterface.IHelloService

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val helloView = findViewById<TextView>(R.id.helloView)
        helloView.text = helloService.createHello()

        findViewById<Button>(R.id.throwButton).setOnClickListener {
            exceptionService.throwNullReferenceException()
        }
    }

    private val helloService: IHelloService = ServiceFactory.createHelloService()
    private val exceptionService: IExceptionService = ServiceFactory.createExceptionService()
}
