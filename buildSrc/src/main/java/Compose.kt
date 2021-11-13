object Compose {
    private const val activityComposeVersion = "1.3.0-rc01"
    const val activity = "androidx.activity:activity-compose:$activityComposeVersion"

    // const val composeVersion = "1.0.0"
    const val composeVersion = "1.0.4" //because of Paging I downgrade Compose Version and Kotlin Version to 1.5.10
    const val compiler = "androidx.compose.compiler:compiler:$composeVersion"
    const val ui = "androidx.compose.ui:ui:$composeVersion"
    const val material = "androidx.compose.material:material:$composeVersion"
    const val tooling = "androidx.compose.ui:ui-tooling:$composeVersion"

    private const val navigationVersion = "2.4.0-alpha04"
    const val navigation = "androidx.navigation:navigation-compose:$navigationVersion"

    private const val hiltNavigationComposeVersion = "1.0.0-alpha03"
    const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion"
    
    
    const val runtimeLiveData = "androidx.compose.runtime:runtime-livedata:$composeVersion" //for connection LiveData
    
    // private const val version = "1.0.0-alpha02"
    private const val pagingVersion = "1.0.0-alpha13"
    const val paging = "androidx.paging:paging-compose:$pagingVersion"
    
    const val foundation      =  "androidx.compose.foundation:foundation:$composeVersion" // Compose for Paging
}

object ComposeTest {
    const val uiTestJunit4 = "androidx.compose.ui:ui-test-junit4:${Compose.composeVersion}"
    const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:${Compose.composeVersion}"
}