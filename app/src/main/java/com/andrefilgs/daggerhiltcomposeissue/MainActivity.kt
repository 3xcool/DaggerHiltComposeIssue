package com.andrefilgs.daggerhiltcomposeissue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.andrefilgs.daggerhiltcomposeissue.navigation.MainNavigation
import com.andrefilgs.daggerhiltcomposeissue.navigation.RootScreen
import com.andrefilgs.daggerhiltcomposeissue.ui.theme.DaggerHiltComposeIssueTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      DaggerHiltComposeIssueTheme { // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
          val navController = rememberNavController()
          Scaffold() {
            MainNavigation(navController = navController, splashFinalRoute = RootScreen.Main.route)
          }
        }
      }
    }
  }
}

@Composable
fun Greeting(name: String) {
  Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  DaggerHiltComposeIssueTheme {
    Greeting("Android")
  }
}