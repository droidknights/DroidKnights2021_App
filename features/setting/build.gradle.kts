plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dep.Compose.version
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":features:core-ui"))
    implementation(project(":features:core-ui-compose"))
    implementation(project(":shared"))

    implementation(Dep.AndroidX.Lifecycle.livedata)
    implementation(Dep.AndroidX.Lifecycle.viewModelCompose)

    implementation(Dep.Compose.ui)
    implementation(Dep.Compose.material)
    implementation(Dep.Compose.tooling)
    implementation(Dep.Compose.themeAdapter)
    implementation(Dep.Compose.liveData)

    implementation(Dep.Coil.compose)

    implementation(Dep.Dagger.hiltAndroid)
    kapt(Dep.Dagger.hiltCompiler)

    implementation(Dep.timber)

    testImplementation(Dep.Test.junit)
    androidTestImplementation(Dep.Test.junitExt)
    androidTestImplementation(Dep.Test.espresso)
}