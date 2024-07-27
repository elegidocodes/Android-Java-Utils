plugins {
    alias(libs.plugins.androidApplication)
    id("maven-publish")
}

android {
    namespace = "com.elegido.android.java.utils"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.elegido.android.java.utils"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.swipeRefreshLayout)
    implementation(libs.zxingAndroidEmbedded)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}

androidComponents {
    onVariants { variant ->
        publishing {
            publications {
                create<MavenPublication>(variant.name) {
                    groupId = "com.github.elegidocodes"
                    artifactId = "Android-Java-Utils"
                    version = "1.0.5"
                    from(components.findByName(variant.name))
                }
            }
        }
    }
}

afterEvaluate {
    publishing {
        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/elegidocodes/Android-Java-Utils")
                credentials {
                    username = project.findProperty("gpr.user")?.toString() ?: System.getenv("GITHUB_ACTOR")
                    password = project.findProperty("gpr.token")?.toString() ?: System.getenv("GITHUB_TOKEN")
                }
            }
        }
    }
}