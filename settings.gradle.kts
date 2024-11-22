import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

pluginManagement {
    repositories {
        maven { url = uri("file:/usr/local/google/home/bingran/studio-main/out/repo/") }
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven { url = uri("file:/usr/local/google/home/bingran/studio-main/out/repo/") }
        google()
        mavenCentral()
    }
}

rootProject.name = "My Application"
include(":app")
include(":library1")
include(":lib2")

gradle.lifecycle.beforeProject {
    println("start to evaluate the project with name $name at time ${LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))}")
}

gradle.lifecycle.afterProject {
    println("project with name $name has just been evaluated at time ${LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))}")
}
