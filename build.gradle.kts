plugins {
    id("java")
    `maven-publish`
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "ru.serj.learn"
version = "1.4"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {

}


tasks {
    publishToMavenLocal {
        dependsOn(clean)
        dependsOn(build)
        dependsOn(shadowJar)
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = rootProject.group.toString()
            artifactId = project.name
            version = rootProject.version.toString()
            from(components["java"])
        }
    }
}
