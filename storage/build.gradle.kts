plugins {
    id(Plugins.library)
    id(Plugins.android)
    id(Plugins.ksp)
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

    implementation (Dependencies.Database.roomRuntime)
    implementation (Dependencies.Network.gson)
    implementation (Dependencies.Network.retofit)
    implementation (Dependencies.Network.retofitConverter)
    implementation (Dependencies.Database.room)
    annotationProcessor (Dependencies.Database.roomAnnotation)
    ksp(Dependencies.Database.ksp)
}
