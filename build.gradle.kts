/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

buildscript {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }
    dependencies {
        classpath(libs.kotlinGradlePlugin)
        classpath(libs.androidGradlePlugin)
        classpath(libs.mokoGradlePlugin)
        classpath(libs.mokoResourcesGradlePlugin)
        classpath(libs.mokoKSwiftGradlePlugin)
    }
}

val mokoVersion = libs.versions.mokoFieldsVersion.get()
allprojects {
    this.group = "dev.icerock.moko"
    this.version = mokoVersion
}
