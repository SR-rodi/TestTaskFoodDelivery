plugins {
    id(Plugins.library)
    id(Plugins.android)
}

android {
    namespace = "ru.sr.testtaskfooddelivery.feature_profile"
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
    buildFeatures {
        viewBinding = true
    }

}
dependencies {

    implementation (Dependencies.Navigation.fragment)
    implementation (Dependencies.Navigation.ui)
    implementation (Dependencies.Core.lifecycle)
    implementation (Dependencies.Core.viewmodel)
}
