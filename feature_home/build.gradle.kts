plugins {
    id(Plugins.library)
    id(Plugins.android)
}

android {
    namespace = "ru.sr.testtaskfooddelivery.feature_home"
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

    implementation(project(Module.coreUi))
    implementation(project(Module.core))
    implementation(project(Module.storage))

    implementation(Dependencies.Navigation.fragment)
    implementation(Dependencies.Navigation.ui)

    implementation(Dependencies.Di.koinCore)
    implementation(Dependencies.Di.koinAndroid)

    implementation(Dependencies.Core.lifecycle)
    implementation(Dependencies.Core.viewmodel)
}
