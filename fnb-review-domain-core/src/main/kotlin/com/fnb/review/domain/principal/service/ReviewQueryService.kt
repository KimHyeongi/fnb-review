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
    fun findByRestaurantIdAndReviewId(@NotNull restaurantId: Long, @NotNull reviewId: Long): ReviewEntity =
        reviewRepository.findByRestaurantIdAndReviewId(restaurantId, reviewId).orElseThrow()

    fun findByRestaurantId(@NotNull restaurantId: Long): MutableList<ReviewEntity> =
        reviewRepository.findByRestaurantId(restaurantId)

}