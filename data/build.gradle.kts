plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(project(":domain"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")

    //communication with rest API
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
//    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
//    implementation "com.squareup.okhttp3:logging-interceptor:$okhttp3LogInterceptor"


    //for working with JSON
    implementation("com.squareup.moshi:moshi:1.15.1")
    implementation ("com.squareup.retrofit2:converter-moshi:2.11.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.15.0")

    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")


//    //dependency injection
//    implementation("org.koin:koin-android:2.0.1")
//    implementation ("org.koin:koin-androidx-viewmodel:2.0.1")
//    implementation ("org.koin:koin-androidx-scope:2.0.1")

    implementation("io.insert-koin:koin-core:3.5.0")

}