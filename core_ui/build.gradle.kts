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

    implementation (Dependencies.Core.material)
    implementation (Dependencies.Image.glide)
}
