import com.android.build.gradle.LibraryExtension
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.api.plugins.ExtensionContainer

/**
 * Created by Bilal Haider on 01/03/2022
 */
fun Project.androidLibrary(
    extensionBlock: (ExtensionContainer.() -> Unit)? = null
) {
    with((this as ExtensionAware).extensions) {
        configure<LibraryExtension>("android") {
            androidLibrary()
        }

        extensionBlock?.invoke(this)
    }
}

fun LibraryExtension.androidLibrary() {
    compileSdk = Versions.TARGET_ANDROID_SDK

    defaultConfig {
        minSdk = Versions.MIN_ANDROID_SDK
        targetSdk = Versions.TARGET_ANDROID_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments["clearPackageData"] = "true"

        consumerProguardFiles("proguard-rules.pro")
    }

    buildTypes {
        getByName("release") {
            buildConfigField("Boolean", "RELEASE", "true")
        }

        getByName("debug") {
            buildConfigField("Boolean", "RELEASE", "false")
        }
    }

    testOptions {
        animationsDisabled = true
        execution = "ANDROIDX_TEST_ORCHESTRATOR"

        unitTests {
            isReturnDefaultValues = true

            all {
                it.testLogging {
                    events("passed", "skipped", "failed")
                }
            }
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.COMPOSE_COMPILER
    }
}