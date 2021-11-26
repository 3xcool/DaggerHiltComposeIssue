package com.andrefilgs.feature1.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NamedNavArgument
import androidx.navigation.compose.composable
import com.andrefilgs.feature1.Feature1Screen
import com.andrefilgs.feature1.Feature1ViewModel

/**
 * Created by andre.filgueiras on 13/11/2021.
 */

sealed class Feature1Routes(val route:String, val arguments:List<NamedNavArgument>){
  
  object Main: Feature1Routes(
    route = "route_feature1_main",
    arguments = emptyList()
  )
}

fun NavGraphBuilder.addFeature1Routes(
  navController: NavController,
  comingRoute:String,
) {
  
  composable(route= Feature1Routes.Main.route){ navBackStackEntry ->
    val viewModel: Feature1ViewModel= hiltViewModel(navController.getViewModelStoreOwner(navController.graph.id))
    // val viewModel: Feature1ViewModel= hiltViewModel(navBackStackEntry)
    // val viewModel: Feature1ViewModel= hiltViewModel(navController.getBackStackEntry(route=comingRoute))
    // val viewModel: Feature1ViewModel= hiltViewModel(navController.graph.parent!!.id)
    // val viewModel: Feature1ViewModel= hiltViewModel(navBackStackEntry.viewModelStore)
    Feature1Screen(viewModel.state, viewModel)
  }
}