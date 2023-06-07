plugins {
    id(Plugins.library)
    id(Plugins.android)
}

android {
    namespace = "ru.sr.testtaskfooddelivery.core"
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

    implementation (Dependencies.Core.material)
    implementation (Dependencies.Core.constraintlayout)
    implementation (Dependencies.Core.lifecycle)
}
