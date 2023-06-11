plugins {
    id("java")
}

group = "de.elia"
version = "1.1.0"

repositories {
    mavenCentral()
    maven {
        setUrl("https://repo.papermc.io/repository/maven-public/")
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20-R0.1-SNAPSHOT")
}

tasks.test {
    useJUnitPlatform()
}