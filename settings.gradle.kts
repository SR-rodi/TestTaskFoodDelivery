pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "TestTaskFoodDelivery"
include (":app")
include (":core")
include (":core_ui")
include (":storage")
include (":feature_home")
include (":feature_search")
include (":feature_profile")
include (":feature_cart")
include (":delegate")