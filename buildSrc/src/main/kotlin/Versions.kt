object Versions {
    const val KOTLIN_VERSION = "1.5.10"
    const val compat = "1.3.1"
    const val dagger = "2.37"
    const val rxandroid = "2.1.1"
    const val rxjava = "2.2.20"
    const val retrofit = "2.9.0"
    const val koin_version = "3.1.2"
    const val coroutines_core = "1.5.1"
    const val coroutines_android = "1.5.0"
    const val core_ktx = "1.6.0"
    const val constraintlayout = "2.1.1"
    const val junit = "4.13.2"
    const val android_junit = "1.1.3"
    const val espresso_core = "3.4.0"
    const val material = "1.4.0"
    const val retrofit2_kotlin_coroutines_adapter = "0.9.2"
    const val kotlin_stdlib_jdk7 = "1.5.20"
    const val logging_interceptor = "4.9.1"
    const val retrofit2_rxjava2_adapter = "1.0.0"
    const val coil = "0.11.0"
    const val room = "2.3.0"
    const val swiperefreshlayout = "1.1.0"
}

object Dependences {
    const val KOTLIN_STD_LIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN_VERSION}"
    const val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val swiperefreshlayout =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swiperefreshlayout}"
    const val junit = "junit:junit:${Versions.junit}"
    const val test_ext = "androidx.test.ext:${Versions.android_junit}"
    const val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso_core}"

    //AndroidX
    const val appcompat = "androidx.appcompat:appcompat:${Versions.compat}"

    const val material = "com.google.android.material:material:${Versions.material}"

    //Kotlin
    const val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    const val kotlin_stdlib_jdk7 =
        "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin_stdlib_jdk7}"

    //Rx-Java
    const val rxandroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"
    const val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"

    //Retrofit 2
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val logging_interceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.logging_interceptor}"
    const val retrofit2_rxjava2_adapter =
        "com.jakewharton.retrofit:retrofit2-rxjava2-adapter:${Versions.retrofit2_rxjava2_adapter}"

    const val DAGGER = "com.google.dagger:dagger:${Versions.dagger}"
    const val dagger_android = "com.google.dagger:dagger-android:${Versions.dagger}"
    const val dagger_android_support = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val dagger_android_processor =
        "com.google.dagger:dagger-android-processor:${Versions.dagger}"

    const val koin_core = "io.insert-koin:koin-core:${Versions.koin_version}"
    const val koin_android = "io.insert-koin:koin-android:${Versions.koin_version}"
    const val koin_android_compat = "io.insert-koin:koin-android-compat:${Versions.koin_version}"

    const val kotlinx_coroutines_core =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines_core}"
    const val kotlinx_coroutines_android =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines_android}"
    const val retrofit2_kotlin_coroutines_adapter =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofit2_kotlin_coroutines_adapter}"

    const val COIL = "io.coil-kt:coil:${Versions.coil}"

    const val ROOM_RUNTIME = "androidx.room:room-runtime:${Versions.room}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.room}"
    const val ROOM_KTX = "androidx.room:room-ktx:${Versions.room}"
}