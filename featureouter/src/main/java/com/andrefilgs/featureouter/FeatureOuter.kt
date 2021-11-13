package com.andrefilgs.featureouter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.andrefilgs.core.domain.SPACER_HEIGHT

/**
 * Created by andre.filgueiras on 13/11/2021.
 */


@Composable
fun FeatureOuterScreen(
  state: MutableState<String>,
  goToFeature01: () -> Unit
) {
  Column(
    modifier = Modifier.fillMaxSize(),
  ) {
    Text(text = "Feature Outer: ${state.value}")
    Spacer(modifier = Modifier.height(SPACER_HEIGHT))
    // Button(onClick = {
    //   goToFeature01()
    // }) {
    //   Text(text = "Go to Feature 01")
    // }
  }
}