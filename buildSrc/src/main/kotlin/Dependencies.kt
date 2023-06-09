import Dependencies.Versions.appcompatVersions
import Dependencies.Versions.constraintlayoutVersions
import Dependencies.Versions.coreKtxVersions
import Dependencies.Versions.glideVersions
import Dependencies.Versions.gsonVersions
import Dependencies.Versions.koinVersions
import Dependencies.Versions.kotlinBoomVersions
import Dependencies.Versions.lifecycleVersions
import Dependencies.Versions.materialVersions
import Dependencies.Versions.navigationVersions
import Dependencies.Versions.okHttpBoomVersions
import Dependencies.Versions.playServisVersions
import Dependencies.Versions.retrofitVersions
import Dependencies.Versions.roomVersions
import Dependencies.Versions.splashScreenVersions

object Dependencies {

    internal object Versions {
        const val coreKtxVersions = "1.10.1"
        const val appcompatVersions = "1.6.1"
        const val constraintlayoutVersions = "2.1.4"
        const val materialVersions = "1.9.0"
        const val kotlinBoomVersions = "1.8.0"
        const val lifecycleVersions = "2.6.1"
        const val roomVersions = "2.5.0"
        const val koinVersions = "3.4.2"
        const val navigationVersions = "2.5.3"
        const val splashScreenVersions = "1.0.1"
        const val playServisVersions = "21.0.1"
        const val okHttpBoomVersions = "4.11.0"
        const val retrofitVersions = "2.9.0"
        const val gsonVersions = "2.10.1"
        const val glideVersions = "4.15.1"
    }

    object Core {
        const val appcompat = ("androidx.appcompat:appcompat:$appcompatVersions")
        const val material = ("com.google.android.material:material:$materialVersions")
        const val constraintlayout =
            ("androidx.constraintlayout:constraintlayout:$constraintlayoutVersions")
        const val coreKtx = ("androidx.core:core-ktx:$coreKtxVersions")
        const val kotlinBoom = ("org.jetbrains.kotlin:kotlin-bom:$kotlinBoomVersions")
        const val lifecycle = ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersions")
        const val viewmodel = ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersions")

    }

    object Database {
        val roomRuntime = ("androidx.room:room-runtime:$roomVersions")
        val room = ("androidx.room:room-ktx:$roomVersions")
        val roomAnnotation = ("androidx.room:room-compiler:$roomVersions")
        val ksp = ("androidx.room:room-compiler:$roomVersions")


    }

    object Di {
        val koinCore = ("io.insert-koin:koin-core:$koinVersions")
        val koinAndroid = ("io.insert-koin:koin-android:$koinVersions")
    }

    object Navigation {
        const val fragment = ("androidx.navigation:navigation-fragment-ktx:$navigationVersions")
        const val ui = ("androidx.navigation:navigation-ui-ktx:$navigationVersions")
    }

    object Network {
        const val gson = ("com.google.code.gson:gson:$gsonVersions")
        const val retofit = ("com.squareup.retrofit2:retrofit:$retrofitVersions")
        const val retofitConverter = ("com.squareup.retrofit2:converter-gson:$retrofitVersions")
        const val okHttpBom = ("com.squareup.okhttp3:okhttp-bom:$okHttpBoomVersions")
        const val okHttp = ("com.squareup.okhttp3:okhttp")
        const val okHttpLogging = ("com.squareup.okhttp3:logging-interceptor")
    }

    object SplashScreen {
        const val splashScreen = ("androidx.core:core-splashscreen:$splashScreenVersions")
    }

    object Location {
        const val playServis = ("com.google.android.gms:play-services-location:$playServisVersions")
    }

    object Image {
        val glide = ("com.github.bumptech.glide:glide:$glideVersions")
    }

}