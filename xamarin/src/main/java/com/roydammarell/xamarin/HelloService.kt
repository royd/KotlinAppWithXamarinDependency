package com.roydammarell.xamarin

import com.roydammarell.xamarindependency.HelloXamarinService

class HelloService {
    fun createHello(): String {
        return helloXamarinService.CreateHelloXamarin()
    }

    private val helloXamarinService = HelloXamarinService()
}