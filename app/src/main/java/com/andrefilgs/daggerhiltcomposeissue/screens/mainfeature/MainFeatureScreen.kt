package com.andrefilgs.daggerhiltcomposeissue.screens.mainfeature

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.andrefilgs.daggerhiltcomposeissue.ui.theme.DaggerHiltComposeIssueTheme

/**
 * Created by andre.filgueiras on 28/10/2021.
 */
@Composable
fun MainFeatureScreen(
  navController: NavController,
  state: MutableState<String>,
  viewModel:MainFeatureViewModel,
  onClick: () -> Unit
) {
  DaggerHiltComposeIssueTheme() {
    Column(
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
      Text(text = "Main Feature ${state.value}")
      Button(onClick = {
        onClick()
      }) {
        Text(text = "Return")
      }
      Spacer(modifier = Modifier.height(20.dp))
      Button(onClick = { viewModel.runWork() }) {
        Text(text = "Run Work")
      }
  
      Button(onClick = { viewModel.stopWork() }) {
        Text(text = "Stop Work")
      }
    }
  }
}

