import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.0"
}

repositories {
    mavenCentral()
}

dependencies {

    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    implementation(kotlin("stdlib-jdk8"))

    implementation("com.google.guava:guava:29.0-jre")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation("org.assertj:assertj-core:3.23.1")
    testImplementation("com.willowtreeapps.assertk:assertk:0.25")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "1.8"
}