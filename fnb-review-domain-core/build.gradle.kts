plugins {
    id("java-library")
    id("java-test-fixtures")
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}

noArg {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}

dependencies {
}

kotlin.sourceSets.main{
    setBuildDir("$buildDir/generated/source/kapt/main")
}
