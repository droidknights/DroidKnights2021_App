plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":features:core-ui"))
    implementation(project(":shared"))

    implementation(Dep.AndroidX.core)
    implementation(Dep.AndroidX.appcompat)
    implementation(Dep.AndroidX.fragment)
    implementation(Dep.AndroidX.material)
    implementation(Dep.AndroidX.Lifecycle.viewModel)
    implementation(Dep.AndroidX.recyclerview)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    implementation(Dep.Kotlin.dateTime)

    implementation(Dep.Dagger.hiltAndroid)
    kapt(Dep.Dagger.hiltCompiler)

    implementation(Dep.timber)

    testImplementation(Dep.Test.junit)
    androidTestImplementation(Dep.Test.junitExt)
    androidTestImplementation(Dep.Test.espresso)
}