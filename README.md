# NulaCore

A library containing shared code for my mods

## Versioning

This library follows the SemVer 2 specification. The format is `major.minor.patch`.

Jar name format: `nulacore-<minecraft version>-<mod version>`

### Example

A mod requires NulaCore v1.3. You can use any version that starts with 1.3 or greater. You cannot use 1.2.

## Installation

### Gradle

In the repositories section of your `build.gradle` file, add my repository:
```groovy
repositories {
    maven {
        url "https://repo.repsy.io/mvn/sidgames5/sidgames5"
    }
}
```

Add the package to the dependencies section:
```groovy
dependencies {
    modImplementation("dev.sidgames:NulaCore:1.0.0")
}
```