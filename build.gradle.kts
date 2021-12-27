plugins {
	id("org.jetbrains.kotlin.jvm") version "1.6.0"
	id("org.jetbrains.intellij") version "0.7.2"
	id("org.jetbrains.grammarkit") version "2021.1"
}

group = "icu.windea"
version = "3.2.1"

intellij {
	version = "2021.3"
	pluginName = "Starbound Text"
}

repositories {
	maven("https://maven.aliyun.com/nexus/content/groups/public")
	mavenCentral()
}

dependencies{
	implementation("org.jetbrains.kotlin:kotlin-stdlib")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
}

sourceSets.main {
	java.srcDirs("src/main/java", "src/main/kotlin", "src/main/gen")
}

java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(11))
	}
}

kotlin {
	jvmToolchain {
		this as JavaToolchainSpec
		languageVersion.set(JavaLanguageVersion.of(11))
	}
}

val projectCompiler = javaToolchains.compilerFor {
	languageVersion.set(JavaLanguageVersion.of(11))
}

tasks {
	compileJava {
		javaCompiler.set(projectCompiler)
	}
	compileTestJava {
		javaCompiler.set(projectCompiler)
	}
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
