plugins {
    id(Plugins.library)
    id(Plugins.android)
}

android {
    namespace = "ru.sr.testtaskfooddelivery.core_ui"
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
    implementation ("com.github.bumptech.glide:glide:4.15.1")

    implementation (Dependencies.Core.material)
}
