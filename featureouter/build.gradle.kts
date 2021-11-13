import dep.BundleAndroidCommon.bundleAndroidX
import dep.BundleCompose.bundleCompose
import dep.BundleCommon.bundleCommon

plugins {
  id("com.android.library")
  kotlin("android")
  id("kotlin-kapt")
  id("kotlin-android")
}



android {
  compileSdk = Android.compileSdk
  // buildToolsVersion = Android.buildTools
  
  defaultConfig {
    minSdk = Android.minSdk
    targetSdk = Android.targetSdk
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  
  }
  
  buildTypes {
    getByName("release") {
      isMinifyEnabled = true
    }
  
    getByName("debug") {
      isMinifyEnabled = false
    }
  }
  
  buildFeatures {
    compose = true
    viewBinding = true
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }
  composeOptions {
    kotlinCompilerExtensionVersion = Compose.composeVersion
  }
  packagingOptions {
    exclude("META-INF/AL2.0")
    exclude("META-INF/LGPL2.1")
  }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
  kotlinOptions {
    jvmTarget = JavaVersion.VERSION_1_8.toString()
    freeCompilerArgs = listOf(
      // "-Xallow-jvm-ir-dependencies",
      "-Xskip-prerelease-check",
      "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi"
    )
  }
}

dependencies {
  implementation(project(Modules.core))
  bundleAndroidX()
  bundleCommon()
  bundleCompose()
}