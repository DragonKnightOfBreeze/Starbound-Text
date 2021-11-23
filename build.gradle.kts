plugins {
	java
	kotlin("jvm") version "1.6.0"
	id("org.jetbrains.intellij") version "0.7.2"
	id("org.jetbrains.grammarkit") version "2021.1"
}

group = "icu.windea"
version = "3.1.1"

intellij {
	version = "2021.2"
	pluginName = "Starbound Text"
}

repositories {
	maven("https://maven.aliyun.com/nexus/content/groups/public")
	mavenCentral()
	maven("https://plugins.gradle.org/m2")
}

dependencies{
	implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.0")
	implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.0")
}

sourceSets {
	main {
		java.srcDir("src/main/gen")
		java.srcDir("src/main/kotlin")
	}
}

tasks {
	compileKotlin {
		kotlinOptions{
			jvmTarget = "11"
			freeCompilerArgs = listOf("-Xjvm-default=all")
		}
	}
	compileTestKotlin {
		kotlinOptions{
			jvmTarget = "11"
			freeCompilerArgs = listOf("-Xjvm-default=all")
		}
	}
	publishPlugin{
		token(System.getenv("IDEA_TOKEN"))
	}
}
