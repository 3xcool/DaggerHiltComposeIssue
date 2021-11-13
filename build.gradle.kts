
buildscript {
    
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Build.androidBuildTools)
        classpath(Build.kotlinGradlePlugin)
        classpath(Build.hiltAndroid)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31") // classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31") // classpath(Build.sqlDelightGradlePlugin)
        // classpath(Kotlin.serializationClassPath)
      // classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.30") // //by adding Android module, Gradle will add this line, just delete it
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}