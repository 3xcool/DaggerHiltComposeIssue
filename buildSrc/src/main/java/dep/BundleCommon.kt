package dep

import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 * Created by andre.filgueiras on 27/10/2021.
 */
object BundleCommon {
  fun DependencyHandler.bundleCommon() {
    add("implementation", WorkManager.runtime)
    add("implementation", WorkManager.ktx)
    add("implementation", WorkManager.hilt)
    add("kapt", WorkManager.compiler)
    add("implementation", Hilt.android)
    add("kapt", Hilt.compiler)
    add("implementation", Kotlinx.coroutinesCore)
    add("implementation", Kotlinx.coroutinesAndroid)
    add("implementation", Kotlinx.serialization)
  }
  
}