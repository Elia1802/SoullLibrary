plugins {
<<<<<<< Updated upstream
    id("java")
=======
    `java-library`
    id("io.papermc.paperweight.userdev") version "1.7.1"
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
>>>>>>> Stashed changes
}

group = "de.elia"
version = "4.0.0"

repositories {
    mavenCentral()
    maven {
        setUrl("https://repo.papermc.io/repository/maven-public/")
        setUrl("https://maven.enginehub.org/repo/")
    }
}

dependencies {
<<<<<<< Updated upstream
    compileOnly("io.papermc.paper:paper-api:1.20.2-R0.1-SNAPSHOT")
    implementation("org.apache.logging.log4j:log4j-api:2.20.0")
    implementation("org.apache.logging.log4j:log4j-core:2.20.0")
}

tasks.test {
    useJUnitPlatform()
=======
    paperDevBundle("1.21.4-R0.1-20241205.222346-7")
    paperweightDevelopmentBundle("io.papermc.paper:dev-bundle:1.21.4-R0.1-20241205.222346-7")
    implementation("org.apache.logging.log4j:log4j-api:3.0.0-beta2")
    implementation("org.apache.logging.log4j:log4j-core:3.0.0-beta2")
}

tasks {

    assemble {
        dependsOn(reobfJar)
    }

    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(21)
    }

    javadoc {
        options.encoding = Charsets.UTF_8.name()
    }

    processResources {
        filteringCharset = Charsets.UTF_8.name()
    }
>>>>>>> Stashed changes
}