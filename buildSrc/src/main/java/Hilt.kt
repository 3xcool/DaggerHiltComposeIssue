object Hilt {
    // const val hiltVersion = "2.37"
    const val hiltVersion = "2.40.2" //This version fixed the viewmodel with parameters in multi module issue
    const val android = "com.google.dagger:hilt-android:$hiltVersion"
    // const val compiler = "com.google.dagger:hilt-compiler:$hiltVersion"
    const val compiler = "com.google.dagger:hilt-android-compiler:$hiltVersion"
    
    
    const val hiltLifecycleViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"  //implementation
}

object HiltTest {
    const val hiltAndroidTesting = "com.google.dagger:hilt-android-testing:${Hilt.hiltVersion}"
}