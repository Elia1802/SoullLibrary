plugins {
    id("java")
}

group = "de.elia"
version = "2.0.1"

repositories {
    mavenCentral()
    maven {
        setUrl("https://repo.papermc.io/repository/maven-public/")
        setUrl("https://maven.enginehub.org/repo/")
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
    implementation("org.apache.logging.log4j:log4j-api:2.20.0")
    implementation("org.apache.logging.log4j:log4j-core:2.20.0")
}

tasks.test {
    useJUnitPlatform()
}