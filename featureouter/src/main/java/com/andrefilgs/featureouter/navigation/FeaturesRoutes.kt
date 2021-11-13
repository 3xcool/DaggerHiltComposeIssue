package com.andrefilgs.featureouter.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NamedNavArgument
import androidx.navigation.compose.composable
import com.andrefilgs.featureouter.FeatureOuterScreen
import com.andrefilgs.featureouter.FeatureOuterViewModel

/**
 * Created by andre.filgueiras on 13/11/2021.
 */

sealed class FeatureOuterRoutes(val route:String, val arguments:List<NamedNavArgument>){
  
  object Main: FeatureOuterRoutes(
    route = "route_feature_outer_main",
    arguments = emptyList()
  )
}

fun NavGraphBuilder.addFeatureOuterRoutes(
  navController: NavController,
  comingRoute:String,
) {
  
  composable(route= FeatureOuterRoutes.Main.route){ navBackStackEntry ->
    // val viewModel: FeatureOuterViewModel= hiltViewModel(navController.getViewModelStoreOwner(navController.graph.id))
    val viewModel: FeatureOuterViewModel = hiltViewModel(navController.getBackStackEntry(route=comingRoute))
    FeatureOuterScreen(viewModel.state){
      navController.navigate(FeatureOuterRoutes.Main.route)
    }
  }
  
}