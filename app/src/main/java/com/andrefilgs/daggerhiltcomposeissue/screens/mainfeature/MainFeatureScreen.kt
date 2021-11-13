package com.andrefilgs.daggerhiltcomposeissue.screens.mainfeature

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.andrefilgs.daggerhiltcomposeissue.ui.theme.DaggerHiltComposeIssueTheme

/**
 * Created by andre.filgueiras on 28/10/2021.
 */
@Composable
fun MainFeatureScreen(
  navController: NavController,
  state: MutableState<String>,
  onClick: () -> Unit
) {
  DaggerHiltComposeIssueTheme() {
    Column(
      modifier = Modifier.fillMaxSize(),
    ) {
      Text(text = "Main Feature ${state.value}")
      Button(onClick = {
        onClick()
      }) {
        Text(text = "Return")
      }
    }
  }
}

