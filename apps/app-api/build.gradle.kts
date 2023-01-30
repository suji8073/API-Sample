import org.springframework.boot.gradle.tasks.bundling.BootJar

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
}

val appMainClassName = "sample.project.kdohyeon.SampleProjectApplicationKt"
tasks.getByName<BootJar>("bootJar") {
    mainClass.set(appMainClassName)
}