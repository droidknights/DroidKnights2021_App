dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
    }
}
rootProject.name = "DroidKnights2021"
include(":app")
include(":data")
include(":domain")
include(":features:ui-core")
include(":features:ui-core-compose")
include(":features:home")
include(":features:schedule")
include(":features:setting")
include(":features:detail")
include(":navigator")
include(":shared")
