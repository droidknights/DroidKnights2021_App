plugins {
    id("com.android.library")
    kotlin("android")
}

android {
}

dependencies {
    implementation(project(":shared"))

    implementation(Dep.AndroidX.core)

    testImplementation(Dep.Test.junit)
    androidTestImplementation(Dep.Test.junitExt)
    androidTestImplementation(Dep.Test.espresso)
}