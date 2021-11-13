package com.andrefilgs.daggerhiltcomposeissue.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.andrefilgs.daggerhiltcomposeissue.screens.main.HomeScreen
import com.andrefilgs.daggerhiltcomposeissue.screens.main.HomeViewModel
import com.andrefilgs.daggerhiltcomposeissue.screens.mainfeature.MainFeatureScreen
import com.andrefilgs.daggerhiltcomposeissue.screens.mainfeature.MainFeatureViewModel
import com.andrefilgs.daggerhiltcomposeissue.screens.splash.addSplashGraph
// import com.andrefilgs.feature1.navigation.Feature1Routes
// import com.andrefilgs.feature1.navigation.addFeature1Routes
import com.andrefilgs.featureouter.navigation.FeatureOuterRoutes
import com.andrefilgs.featureouter.navigation.addFeatureOuterRoutes
import com.andrefilgs.features.FeaturesScreen
import com.andrefilgs.features.FeaturesViewModel
import com.andrefilgs.features.navigation.FeaturesRoutes
import com.andrefilgs.features.navigation.addFeaturesRoutes

/**
 * Created by andre.filgueiras on 13/11/2021.
 */

@Composable
fun MainNavigation(
  navController: NavHostController,
  splashFinalRoute: String,
) {
  NavHost(
    navController = navController,
    startDestination = RootScreen.Splash.route
  ) {
    addSplashGraph(navController, splashFinalRoute)
    addMainGraph(navController, splashFinalRoute)
  }
}

private fun NavGraphBuilder.addMainGraph(
  navController: NavController,
  splashFinalRoute: String,
){
  navigation(route = splashFinalRoute, startDestination = MainRoutes.Home.route){
    composable(MainRoutes.Home.route) {
      val viewModel: HomeViewModel = hiltViewModel()  //#look: working!!!
      HomeScreen(
        navController = navController,
        state= viewModel.state,
        goToMainFeature = {
          navController.navigate(MainRoutes.MainFeature.route)
        },
        goToOuterFeature = {
          navController.navigate(FeatureOuterRoutes.Main.route)
        },
        goToFeature01 = {
          // navController.navigate(Feature1Routes.Main.route)
        }
      ){
        navController.navigate(FeaturesRoutes.FeaturesMain.route)
      }
    }
    
    composable(MainRoutes.MainFeature.route) {
      val viewModel: MainFeatureViewModel = hiltViewModel()  //#look: working!!!
      MainFeatureScreen(
        navController = navController,
        state= viewModel.state,
      ){
        navController.navigate(MainRoutes.Home.route){
          popUpTo(MainRoutes.MainFeature.route) {
            inclusive = true
          }
        }
      }
    }
    
    // addFeature1Routes(navController, MainRoutes.Home.route)
    addFeatureOuterRoutes(navController, MainRoutes.Home.route)
    addFeaturesRoutes(navController, MainRoutes.Home.route)
  }
}