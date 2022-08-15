package com.fnb.review.domain.principal.service

import com.fnb.review.domain.principal.entity.ReviewEntity
import com.fnb.review.domain.principal.repository.ReviewRepository
import org.jetbrains.annotations.NotNull
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ReviewQueryService(
    val reviewRepository: ReviewRepository
) {
    fun findById(@NotNull id: Long): ReviewEntity =
        checkNotNull(reviewRepository.findByIdOrNull(id)) { "${id}에 해당하는 리뷰정보가 없습니다." }
}