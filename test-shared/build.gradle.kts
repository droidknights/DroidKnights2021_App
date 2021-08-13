plugins {
    id("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(Dep.Test.junit)
    api(Dep.Kotlin.Test.coroutineTest)
    api(Dep.Test.mockitoKotlin)
}