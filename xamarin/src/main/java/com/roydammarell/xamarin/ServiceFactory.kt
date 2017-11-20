package com.roydammarell.xamarin

import com.roydammarell.xamarindependency.ExceptionXamarinService
import com.roydammarell.xamarindependency.HelloXamarinService
import com.roydammarell.xamarininterface.IExceptionService
import com.roydammarell.xamarininterface.IHelloService

class ServiceFactory {
    companion object {
        @JvmStatic
        fun createExceptionService(): IExceptionService {
            return ExceptionXamarinService()
        }

        @JvmStatic
        fun createHelloService(): IHelloService {
            return HelloXamarinService()
        }
    }
}