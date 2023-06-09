plugins {
    id(Plugins.library)
    id(Plugins.android)
}

android {
    namespace = "ru.sr.testtaskfooddelivery.feature_location"
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
    implementation(project(Module.core))
    implementation(project(Module.coreUi))

    implementation (Dependencies.Navigation.fragment)
    implementation (Dependencies.Navigation.ui)

    implementation(Dependencies.Di.koinCore)
    implementation(Dependencies.Di.koinAndroid)
    implementation(Dependencies.Di.koinCore)
    implementation(Dependencies.Di.koinAndroid)

    implementation(Dependencies.Location.playServis)

    implementation(Dependencies.Core.viewmodel)
    implementation(Dependencies.Core.lifecycle)
}
