plugins {
    id(Plugins.library)
    id(Plugins.android)
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "ru.sr.testtaskfooddelivery.storage"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
    }

    compileOptions {
        sourceCompatibility = Config.javaVersion
        targetCompatibility = Config.javaVersion
    }
    kotlinOptions {
        jvmTarget = Config.jmvTarget
    }
}
dependencies {

    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation (Dependencies.Database.roomRuntime)
    implementation (Dependencies.Database.room)
    annotationProcessor (Dependencies.Database.roomAnnotation)
    kapt("androidx.room:room-compiler:2.5.1")

}
