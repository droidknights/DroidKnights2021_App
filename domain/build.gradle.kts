plugins {
    id("com.android.library")
    kotlin("android")
}

android {
}

dependencies {
    implementation(project(":shared"))
    implementation(project(":data"))

    implementation(Dep.AndroidX.core)
    implementation(Dep.AndroidX.appcompat)
    implementation(Dep.AndroidX.material)

    implementation(Dep.inject)

    implementation(Dep.Kotlin.coroutine)
    implementation(Dep.Kotlin.dateTime)

    implementation(Dep.timber)

    testImplementation(project(":test-shared"))
    testImplementation(Dep.Test.junit)
    androidTestImplementation(Dep.Test.junitExt)
    androidTestImplementation(Dep.Test.espresso)
}