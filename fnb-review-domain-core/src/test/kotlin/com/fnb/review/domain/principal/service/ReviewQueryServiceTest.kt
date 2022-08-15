package com.fnb.review.domain.principal.service

import com.fnb.review.domain.principal.mock.ReviewMock
import com.fnb.review.domain.principal.repository.ReviewRepository
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import mu.KotlinLogging
import org.springframework.data.repository.findByIdOrNull

internal class ReviewQueryServiceTest : StringSpec() {
    private val log = KotlinLogging.logger { }

    init {
        "특정 ID 값으로 조회 한다. 기본 Mock 정상반환" {
            every { reviewRepository.findByIdOrNull(any()) } returns ReviewMock.review()
            val resultMockReview = sut.findById(1)
            resultMockReview.contents shouldBe  "Review"
            verify (exactly = 1) { reviewRepository.findByIdOrNull(any()) }
        }
    }

    private val reviewRepository = mockk<ReviewRepository>()
    private val sut = ReviewQueryService(reviewRepository)
}