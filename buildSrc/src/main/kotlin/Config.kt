import org.gradle.api.JavaVersion

object Config {
    const val namespace = "ru.sr.testtaskfooddelivery"
    const val compileSdk = 33

    const val applicationId = "ru.sr.surfit"
    const val minSdk = 26
    const val targetSdk = 33
    const val versionCode = 1
    const val versionName = "1.0"

    val javaVersion = JavaVersion.VERSION_17

    const val jmvTarget = "17"
    const val kotlinCompilerExtensionVersion = "1.4.4"
}