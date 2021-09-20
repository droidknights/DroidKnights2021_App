dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "DroidKnights2021"
include(
    ":app",
    ":data",
    ":domain",
    ":features:core-ui",
    ":features:core-ui-compose",
    ":features:home",
    ":features:schedule",
    ":features:setting",
    ":features:detail",
    ":navigator",
    ":shared",
    ":test-shared",
)
