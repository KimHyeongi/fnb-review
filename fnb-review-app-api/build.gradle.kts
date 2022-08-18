plugins {
}

dependencies {
    implementation("org.mariadb.jdbc:mariadb-java-client:3.0.7")
    testImplementation(testFixtures(project(":fnb-review-domain-core")))
}