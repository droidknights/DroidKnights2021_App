plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdk = Versions.compileSdk
    buildToolsVersion = Versions.buildTools

    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dep.Compose.version
    }
}

dependencies {
    implementation(project(":shared"))

    implementation(Dep.AndroidX.core)
    implementation(Dep.AndroidX.Activity.compose)
    implementation(Dep.AndroidX.fragment)

    implementation(Dep.Compose.ui)
    implementation(Dep.Compose.material)
    implementation(Dep.Compose.tooling)
    implementation(Dep.Compose.themeAdapter)

    implementation(Dep.timber)

    testImplementation(Dep.Test.junit)
    androidTestImplementation(Dep.Test.junitExt)
    androidTestImplementation(Dep.Test.espresso)
}