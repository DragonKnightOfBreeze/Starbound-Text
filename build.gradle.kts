import org.jetbrains.changelog.*
import org.jetbrains.kotlin.gradle.tasks.*
import org.jetbrains.kotlin.utils.*

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.7.22"
    id("org.jetbrains.intellij") version "1.11.0"
    id("org.jetbrains.grammarkit") version "2022.3"
    id("org.jetbrains.changelog") version "2.0.0"
}

group = "icu.windea"
version = "3.3"

intellij {
    pluginName.set("Starbound Text")
    version.set("2022.3")
}

repositories {
    //maven("https://maven.aliyun.com/nexus/content/groups/public")
    mavenCentral()
    maven("https://www.jetbrains.com/intellij-repository/releases")
}

dependencies {
    //JUNIT
    testImplementation("junit:junit:4.13.2")
}

sourceSets {
    main {
        java.srcDirs("src/main/java", "src/main/kotlin", "src/main/gen")
        resources.srcDirs("src/main/resources")
    }
    test {
        java.srcDirs("src/test/java", "src/test/kotlin")
        resources.srcDirs("src/test/resources")
    }
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks {
    withType<Copy> {
        duplicatesStrategy = DuplicatesStrategy.INCLUDE //需要加上
    }
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "17"
            freeCompilerArgs = listOf("-Xjvm-default=all")
        }
    }
    test {
        useJUnitPlatform()
    }
    jar {
        from("README.md", "README_en.md", "LICENSE")
    }
    patchPluginXml {
        sinceBuild.set("223")
        untilBuild.set("")
        val descriptionText = projectDir.resolve("DESCRIPTION.md").readText()
        pluginDescription.set(descriptionText)
        val changelogText = projectDir.resolve("CHANGELOG.md").readText()
            .lines()
            .run {
                val start = indexOfFirst { it.startsWith("## ${version.get()}") }
                val end = indexOfFirst(start + 1) { it.startsWith("## ") }.let { if(it != -1) it else size }
                subList(start + 1, end)
            }
            .joinToString("\n")
            .let { it.replace("* [ ]", "*") }
            .let { markdownToHTML(it) }
        changeNotes.set(changelogText)
    }
    prepareSandbox {

    }
    runIde {
        systemProperties["idea.is.internal"] = true
        jvmArgs("-Xmx4096m") //自定义JVM参数
    }
    publishPlugin {
        token.set(System.getenv("IDEA_TOKEN"))
    }
}
