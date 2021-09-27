plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    defaultConfig {
        applicationId = "com.droidknights.app2021"
        versionCode = Versions.versionCode
        versionName = Versions.versionName
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation(project(":features:home"))
    implementation(project(":features:schedule"))
    implementation(project(":features:setting"))
    implementation(project(":features:detail"))
    implementation(project(":navigator"))
    implementation(project(":shared"))
    implementation(project(":domain"))
    implementation(project(":data"))

    implementation(Dep.AndroidX.core)
    implementation(Dep.AndroidX.appcompat)
    implementation(Dep.AndroidX.material)
    implementation(Dep.AndroidX.constraintLayout)
    implementation(Dep.AndroidX.Navigation.fragment)
    implementation(Dep.AndroidX.Navigation.ui)

    implementation(Dep.Dagger.hiltAndroid)
    kapt(Dep.Dagger.hiltCompiler)

    implementation(Dep.Kotlin.coroutine)

    implementation(Dep.timber)

    testImplementation(Dep.Test.junit)
    androidTestImplementation(Dep.Test.junitExt)
    androidTestImplementation(Dep.Test.espresso)
}