package dep

import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 * Created by andre.filgueiras on 27/10/2021.
 */
object BundleAndroidCommon {
  fun DependencyHandler.bundleAndroidX() {
    add("implementation", AndroidX.constraintlayout)
    add("implementation", AndroidX.coreKtx)
    add("implementation", AndroidX.appCompat)
    add("implementation", AndroidX.material)
    add("implementation", AndroidX.activityKtx)
    add("implementation", AndroidX.fragmentKtx)
    add("implementation", AndroidX.lifecycleRuntimeKtx)
    add("implementation", AndroidX.lifecycleExtensions)
    add("implementation", AndroidX.lifecycleVmKtx)
    add("implementation", AndroidX.lifecycleLiveDataKtx)
    add("implementation", AndroidX.lifecycleCommonJava8Ktx)
    add("implementation", AndroidX.lifecycleVmSavedStateKtx)
  }
}
