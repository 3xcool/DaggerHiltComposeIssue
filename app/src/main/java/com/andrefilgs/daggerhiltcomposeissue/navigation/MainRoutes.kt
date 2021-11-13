package com.andrefilgs.daggerhiltcomposeissue.navigation

import androidx.navigation.compose.NamedNavArgument

sealed class RootScreen(val route:String){
  object Splash: RootScreen("splash")
  object Main: RootScreen("main")
}


sealed class MainRoutes(val route:String, val arguments:List<NamedNavArgument>){
  
  object Home: MainRoutes(
    route = "route_home",
    arguments = emptyList()
  )
  
  object MainFeature: MainRoutes(
    route = "route_main_feature",
    arguments = emptyList()
  )
}