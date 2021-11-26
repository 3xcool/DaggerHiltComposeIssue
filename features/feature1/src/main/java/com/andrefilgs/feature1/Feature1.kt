package com.andrefilgs.feature1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Created by andre.filgueiras on 13/11/2021.
 */


@Composable
fun Feature1Screen(state: MutableState<String>, viewModel: Feature1ViewModel) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp),
  ) {
    Text(text = "Feature 01 Main: ${state.value}")
    
    Button(onClick = { viewModel.runWork() }) {
      Text(text = "Run Work")
    }
  
    Button(onClick = { viewModel.stopWork() }) {
      Text(text = "Stop Work")
    }
  }
}