package com.roydammarell.xamarin

import com.roydammarell.xamarindependency.ExceptionXamarinService

class ExceptionService {

    fun throwNullReferenceException() {
        exceptionXamarinService.throwNullReferenceException()
    }

    private val exceptionXamarinService = ExceptionXamarinService()
}