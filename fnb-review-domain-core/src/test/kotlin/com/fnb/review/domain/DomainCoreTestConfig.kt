package com.fnb.review.domain

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.spec.IsolationMode
import io.kotest.core.test.AssertionMode
import io.kotest.extensions.spring.SpringExtension
import io.mockk.clearAllMocks

object DomainCoreTestConfig : AbstractProjectConfig() {
    override val parallelism = 3
    override val assertionMode = AssertionMode.Error
    override val globalAssertSoftly = true
    override val failOnIgnoredTests = false
    override val isolationMode = IsolationMode.SingleInstance

    override fun afterAll() {
        clearAllMocks()
    }

    override fun extensions() = listOf(SpringExtension)
}