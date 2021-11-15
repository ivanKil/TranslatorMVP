plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}
//apply from : 'lib_version.gradle'

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "com.lessons.translatormvp"
        minSdk = 23
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//        javaCompileOptions {
//            annotationProcessorOptions {
//                arguments += ["room.schemaLocation": "$projectDir/schemas".toString()]
//            }
//        }
        kapt {
            arguments {
                arg("room.schemaLocation", "$projectDir/schemas")
            }
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        android.buildFeatures.viewBinding = true
    }

}

dependencies {
    implementation(Dependences.KOTLIN_STD_LIB)

    implementation(Dependences.constraintlayout)
    implementation(Dependences.swiperefreshlayout)
    implementation(project(mapOf("path" to ":models")))
    testImplementation(Dependences.junit)
    androidTestImplementation(Dependences.junit)
    androidTestImplementation(Dependences.espresso_core)

    //AndroidX
    implementation(Dependences.appcompat)

    //Design
    //You should not use the com.android.support and com.google.android.material dependencies in your app at the same time
    implementation(Dependences.material)

    //Kotlin
    implementation(Dependences.core_ktx)
    implementation(Dependences.kotlin_stdlib_jdk7)

    //Rx-Java
    implementation(Dependences.rxandroid)
    implementation(Dependences.rxjava)

    //Retrofit 2
    implementation(Dependences.retrofit)
    implementation(Dependences.converter_gson)
    implementation(Dependences.logging_interceptor)
    implementation(Dependences.retrofit2_rxjava2_adapter)

    implementation(Dependences.DAGGER)
    implementation(Dependences.dagger_android)
    implementation(Dependences.dagger_android_support)
    kapt(Dependences.dagger_compiler)
    kapt(Dependences.dagger_android_processor)

    implementation(Dependences.koin_core)
    implementation(Dependences.koin_android)
    implementation(Dependences.koin_android_compat)

    implementation(Dependences.kotlinx_coroutines_core)
    implementation(Dependences.kotlinx_coroutines_android)
    implementation(Dependences.retrofit2_kotlin_coroutines_adapter)

    implementation(Dependences.COIL)

    implementation(Dependences.ROOM_RUNTIME)
    kapt(Dependences.ROOM_COMPILER)
    implementation(Dependences.ROOM_KTX)
    implementation(project(":utils"))
}