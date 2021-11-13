import dep.BundleAndroidCommon.bundleAndroidX
import dep.BundleCompose.bundleCompose
import dep.BundleCommon.bundleCommon



plugins {
  id("com.android.application")
  kotlin("android")
  id("kotlin-kapt")
  id("dagger.hilt.android.plugin")
  
  //For Kotlin Serialization
  kotlin(KotlinPlugins.serialization) version Kotlin.version
  
  id("kotlin-android")
}


android {
  compileSdk = Android.compileSdk
  // buildToolsVersion = Android.buildTools
  
  defaultConfig {
    applicationId = Android.appId
    minSdk = Android.minSdk
    targetSdk = Android.targetSdk
    versionCode = Android.versionCode
    versionName = Android.versionName
  
    vectorDrawables.useSupportLibrary = true
    
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

  }
  
  buildTypes {

    val booleanType = "Boolean"

    getByName("debug") {
      buildConfigField(booleanType, Build.Graylog.ENABLE, false.toString())
      isMinifyEnabled = false
      isShrinkResources = false
      isDebuggable = true
    }


    getByName("release") {
      buildConfigField(booleanType, Build.Graylog.ENABLE, true.toString())

      isMinifyEnabled = true
      isShrinkResources = true
      isDebuggable = false
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
      )
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
  implementation(project(Modules.features))
  implementation(project(Modules.featureouter))
  implementation(project(Modules.feature1)) //ATTENTION, must import feature1 here for ViewModel with parameter
  bundleAndroidX()
  bundleCommon()
  bundleCompose()
  // implementation("androidx.navigation:navigation-compose:1.0.0")
}










