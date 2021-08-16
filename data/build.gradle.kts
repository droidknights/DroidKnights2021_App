plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("kotlinx-serialization")
}

android {
}

dependencies {
    implementation(project(":shared"))

    implementation(Dep.AndroidX.core)

    implementation(Dep.Kotlin.serialization)
    implementation(Dep.Kotlin.dateTime)

    implementation(Dep.Dagger.hiltAndroid)
    kapt(Dep.Dagger.hiltCompiler)

    api(Dep.Square.retrofit)
    implementation(Dep.Square.serialization)
    implementation(Dep.Square.okhttp3_logging)

    implementation(Dep.timber)

    testImplementation(Dep.Test.junit)
    androidTestImplementation(Dep.Test.junitExt)
    androidTestImplementation(Dep.Test.espresso)
}