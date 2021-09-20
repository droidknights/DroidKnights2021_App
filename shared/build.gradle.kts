plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlinx-serialization")
}

android {
}

dependencies {
    implementation(Dep.Kotlin.coroutine)
    implementation(Dep.Kotlin.dateTime)
    implementation(Dep.Kotlin.serialization)

    implementation(Dep.inject)

    testImplementation(Dep.Test.junit)
    androidTestImplementation(Dep.Test.junitExt)
    androidTestImplementation(Dep.Test.espresso)
}