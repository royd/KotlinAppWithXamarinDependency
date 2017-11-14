package com.roydammarell.library

import xamarindependency.library.*

class HelloService {
    fun createHello(): String {
        return helloXamarinService.CreateHelloXamarin()
    }

    private val helloXamarinService = HelloXamarinService()
}