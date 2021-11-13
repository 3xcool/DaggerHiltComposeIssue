package com.andrefilgs.daggerhiltcomposeissue.screens.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.andrefilgs.daggerhiltcomposeissue.R
import com.andrefilgs.daggerhiltcomposeissue.navigation.RootScreen
import kotlinx.coroutines.delay

fun NavGraphBuilder.addSplashGraph(navController: NavHostController, splashFinalRoute: String){
  composable(route= RootScreen.Splash.route){
    SplashScreen(){
      navController.navigate(splashFinalRoute){
        popUpTo(RootScreen.Splash.route) {
          inclusive = true
        }
      }
    }
  }
}


@Composable
fun SplashScreen(
  afterSplash : () -> Unit
) {

  val scale = remember{
    Animatable(0f)
  }
  //By setting key1 to true this coroutine will be run only once
  LaunchedEffect(key1 = true){
    scale.animateTo(
      targetValue = 1.2f,
      animationSpec = tween(
        durationMillis = 500,
        easing = {
          OvershootInterpolator(2f).getInterpolation(it)
        }
      )
    )
    delay(1000L)
    afterSplash()
  }
  Box(
    contentAlignment = Alignment.Center,
    modifier = Modifier.fillMaxSize()
  ) {
    Image(
      painter = painterResource(id = R.drawable.ic_android_black_24dp),
      contentDescription = "Logo",
      modifier = Modifier
        .scale(scale.value)
        // .paint(
        //   colorFilter = ColorFilter.tint(color = Color.Blue),
        //   painter = painterResource(id = R.drawable.bg_splash)
        // )
    )
  }
}