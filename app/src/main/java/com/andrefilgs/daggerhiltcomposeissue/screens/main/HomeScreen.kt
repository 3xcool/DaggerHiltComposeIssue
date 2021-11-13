package com.andrefilgs.daggerhiltcomposeissue.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.andrefilgs.core.domain.SPACER_HEIGHT
import com.andrefilgs.daggerhiltcomposeissue.ui.theme.DaggerHiltComposeIssueTheme


/**
 * Created by andre.filgueiras on 28/10/2021.
 */
@Composable
fun HomeScreen(
  navController: NavController,
  state: MutableState<String>,
  goToMainFeature: () -> Unit,
  goToOuterFeature: () -> Unit,
  goToFeature01: () -> Unit,
  onClick: () -> Unit
) {
  DaggerHiltComposeIssueTheme() {
    Column(
      modifier = Modifier.fillMaxSize(),
    ) {
      Text(text = "Home Screen ${state.value}")
      
      Spacer(modifier = Modifier.height(SPACER_HEIGHT))
      Button(onClick = {
        goToMainFeature()
      }) {
        Text(text = "Go to Main Features")
      }
      
      Spacer(modifier = Modifier.height(SPACER_HEIGHT))
      Button(onClick = {
        onClick()
      }) {
        Text(text = "Go to Features")
      }
  
      Spacer(modifier = Modifier.height(SPACER_HEIGHT))
      Button(onClick = {
        goToOuterFeature()
      }) {
        Text(text = "Go to Outer Feature")
      }
  
      Spacer(modifier = Modifier.height(SPACER_HEIGHT))
      Button(onClick = {
        goToFeature01()
      }) {
        Text(text = "Go to Feature 01")
      }
    }
  }
}

