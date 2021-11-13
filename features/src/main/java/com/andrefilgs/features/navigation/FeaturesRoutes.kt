package com.andrefilgs.features.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NamedNavArgument
import androidx.navigation.compose.composable
import com.andrefilgs.feature1.Feature1ViewModel
import com.andrefilgs.feature1.navigation.Feature1Routes
import com.andrefilgs.feature1.navigation.addFeature1Routes
import com.andrefilgs.featureouter.navigation.FeatureOuterRoutes
import com.andrefilgs.featureouter.navigation.addFeatureOuterRoutes
import com.andrefilgs.features.FeaturesScreen
import com.andrefilgs.features.FeaturesViewModel

/**
 * Created by andre.filgueiras on 13/11/2021.
 */

sealed class FeaturesRoutes(val route:String, val arguments:List<NamedNavArgument>){
  
  object FeaturesMain: FeaturesRoutes(
    route = "route_features_main",
    arguments = emptyList()
  )
}

fun NavGraphBuilder.addFeaturesRoutes(
  navController: NavController,
  comingRoute:String,
) {
  
  composable(route= FeaturesRoutes.FeaturesMain.route){ navBackStackEntry ->
    // val viewModel: FeaturesViewModel= hiltViewModel(navController.getViewModelStoreOwner(navController.graph.id))
    val viewModel: FeaturesViewModel = hiltViewModel(navController.getBackStackEntry(route=comingRoute))
    FeaturesScreen(viewModel.state,
    goToFeatureOuter = {
      navController.navigate(FeatureOuterRoutes.Main.route)
    }){
      navController.navigate(Feature1Routes.Main.route)
    }
  }
  
  addFeatureOuterRoutes(navController, comingRoute = comingRoute)
  addFeature1Routes(navController, comingRoute = comingRoute)
}