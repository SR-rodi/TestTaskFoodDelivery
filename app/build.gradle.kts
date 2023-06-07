plugins {
    id (Plugins.application)
    id (Plugins.android)
}

android {
    namespace = Config.namespace
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.namespace
        minSdk  = Config.minSdk
        targetSdk =  Config.targetSdk
        versionCode =  Config.versionCode
        versionName  = Config.versionName
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            //proguardFiles getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
        }
    }
    compileOptions {
        sourceCompatibility = Config.javaVersion
        targetCompatibility = Config.javaVersion
    }
    kotlinOptions {
        jvmTarget = Config.jmvTarget
    }
    buildFeatures {
        viewBinding  = true
    }
}

dependencies {

    implementation(project(Module.featureCart))
    implementation(project(Module.featureProfile))
    implementation(project(Module.featureHome))
    implementation(project(Module.featureSearch))
    implementation(project(Module.storage))
    implementation(project(Module.core))

    implementation (Dependencies.Navigation.fragment)
    implementation (Dependencies.Navigation.ui)

    implementation(Dependencies.Database.room)

    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.google.code.gson:gson:2.10.1")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.11.0"))
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")

    implementation( Dependencies.Di.koinCore)
    implementation( Dependencies.Di.koinAndroid)

    implementation (Dependencies.Core.coreKtx)
    implementation (Dependencies.Core.appcompat)
    implementation (Dependencies.Core.material)
    implementation (Dependencies.Core.constraintlayout)
    implementation (Dependencies.Core.lifecycle)
    implementation (Dependencies.Core.viewmodel)

}