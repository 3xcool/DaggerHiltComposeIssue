package dep

import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 * Created by andre.filgueiras on 27/10/2021.
 */
object BundleCompose {
  fun DependencyHandler.bundleCompose() {
    add("implementation", Compose.compiler)
    add("implementation", Compose.activity)
    add("implementation", Compose.ui)
    add("implementation", Compose.material)
    add("implementation", Compose.navigation)
    add("implementation", Compose.hiltNavigation)
    add("implementation", Compose.tooling)
    add("implementation", Compose.foundation)
    add("implementation", Compose.runtimeLiveData)
    add("implementation", Compose.paging)
  }
}