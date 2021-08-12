import dependencies.Dep

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath Dep.androidGradlePlugin
        classpath Dep.Kotlin.gradlePlugin
        classpath Dep.Kotlin.serializationPlugin
        classpath Dep.Dagger.hiltGradlePlugin
    }
}

task clean (type: Delete) {
    delete rootProject.buildDir
}