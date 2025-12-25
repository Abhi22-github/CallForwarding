// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.android.detekt) apply false
    alias(libs.plugins.android.ktlint) apply false
}

tasks.register("format") {
    group = "formatting"
    description = "Formats Kotlin code using ktlint"
    dependsOn(":app:ktlintFormat")
}

tasks.register("ktlint") {
    group = "verification"
    description = "Runs ktlint and detekt"
    dependsOn(
        ":app:ktlintCheck",
        ":app:detekt"
    )
}






