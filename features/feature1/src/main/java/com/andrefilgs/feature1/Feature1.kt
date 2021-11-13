package com.andrefilgs.feature1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier

/**
 * Created by andre.filgueiras on 13/11/2021.
 */


@Composable
fun Feature1Screen(state: MutableState<String>) {
  Column(
    modifier = Modifier.fillMaxSize(),
  ) {
    Text(text = "Feature 01 Main: ${state.value}")
  }
}