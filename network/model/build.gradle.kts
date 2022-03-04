import com.codingfeline.buildkonfig.compiler.FieldSpec.Type

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("com.codingfeline.buildkonfig")
}



kotlin {
    android()

    sourceSets {
        all {
            languageSettings.apply {
                apiVersion = "1.6"
                languageVersion = "1.6"
                progressiveMode = true
                optIn("kotlinx.serialization.ExperimentalSerializationApi")
            }
        }

        val commonMain by getting {
            dependencies {
                api("org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.2")
                api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
            }
        }
//        val commonTest by getting {
//            dependencies {
//
//                implementation(kotlin("test-common"))
//                implementation(kotlin("test-annotations-common"))
//            }
//        }

//        val androidMain by getting
//        val androidTest by getting {
//            dependencies {
//                implementation(kotlin("test-junit"))
//                implementation("junit:junit:4.13.2")
//            }
//        }
    }
}

multiplatformLibrary()

buildkonfig {
    packageName = "co.uk.bilalhaider.cats.model"

    defaultConfigs {
        buildConfigField(Type.BOOLEAN, "RELEASE", "false")
        buildConfigField(Type.BOOLEAN, "DEBUG", "true")
    }

    defaultConfigs("release") {
        buildConfigField(Type.BOOLEAN, "RELEASE", "true")
        buildConfigField(Type.BOOLEAN, "DEBUG", "false")
    }
}