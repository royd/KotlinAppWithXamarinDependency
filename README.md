# KotlinAppWithXamarinDependency
A native Android app that consumes C# dependencies using Xamarin

### Goals
* Consume C# dependencies without a Xamarin app
* Minimize Xamarin build time
* Minimize use of Xamarin Studio/Visual Studio

### Implementation
Integrates the following components supplied by [XamarinDependency](https://github.com/royd/XamarinDependency)
* Mono runtime
* C# assemblies
* Android Callable Wrappers

C# dependencies are supplied using C# classes that implement or extend Managed Callable Wrappers of Java or Kotlin interfaces or classes.

Native factory classes in Kotlin or Java supply implementations for the C# classes using Xamarin generated Android Callable Wrappers.

While it would also be possible to generate Android Callable Wrappers using the `[Java.Interop.ExportAttribute]`, this method obtains better stacktraces for exceptions thrown in C#.

For example:
```
E/AndroidRuntime: FATAL EXCEPTION: main
    Process: com.roydammarell.kotlinappwithxamarindependency, PID: 1690
    android.runtime.JavaProxyThrowable: System.NullReferenceException: Testing C# NullReferenceException
     at XamarinDependency.Library.ExceptionXamarinService.ThrowNullReferenceException () [0x00001] in <34b5ec4fa70f4f66b8305c760c86d6e6>:0 
     at Com.Roydammarell.Xamarininterface.IExceptionServiceInvoker.n_ThrowNullReferenceException (System.IntPtr jnienv, System.IntPtr native__this) [0x0000a] in <0dbbbb0b237643739178979927a37579>:0 
       at (wrapper dynamic-method) System.Object:287cba4a-4292-4192-97c4-df75761b87a8 (intptr,intptr)
       at com.roydammarell.xamarindependency.ExceptionXamarinService.n_throwNullReferenceException(Native Method)
       at com.roydammarell.xamarindependency.ExceptionXamarinService.throwNullReferenceException(ExceptionXamarinService.java:30)
       at com.roydammarell.kotlinappwithxamarindependency.MainActivity$onCreate$1.onClick(MainActivity.kt:21)
       at android.view.View.performClick(View.java:5609)
       at android.view.View$PerformClick.run(View.java:22259)
       at android.os.Handler.handleCallback(Handler.java:751)
       at android.os.Handler.dispatchMessage(Handler.java:95)
       at android.os.Looper.loop(Looper.java:154)
       at android.app.ActivityThread.main(ActivityThread.java:6077)
       at java.lang.reflect.Method.invoke(Native Method)
       at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:865)
       at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:755)
```

The build is configured entirely in Gradle, with a stock MSBuild Xamarin build to insulate against breaking Xamarin updates.

While it would be possible to implement UI in Xamarin, the goal of this project is specifically to *not* have UI in Xamarin.
