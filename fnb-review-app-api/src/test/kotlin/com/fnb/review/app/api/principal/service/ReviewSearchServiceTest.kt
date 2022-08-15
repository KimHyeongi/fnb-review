package com.fnb.review.app.api.principal.service

import com.fnb.review.domain.principal.mock.ReviewMock
import com.fnb.review.domain.principal.service.ReviewQueryService
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import mu.KotlinLogging

import org.junit.jupiter.api.Assertions.*

internal class ReviewSearchServiceTest: StringSpec() {
    private val log = KotlinLogging.logger { }

    init {
        "특정 ID 값으로 조회 한다. 기본 Mock 정상반환" {
            every { reviewQueryService.findById(any()) } returns ReviewMock.review()
            val resultMockReview = sut.findOne(1L)

            resultMockReview.contents shouldBe  "Review"
            verify (exactly = 1) { reviewQueryService.findById(any()) }
        }
    }

    private val reviewQueryService = mockk<ReviewQueryService>()
    private val sut = ReviewSearchService(reviewQueryService)
}