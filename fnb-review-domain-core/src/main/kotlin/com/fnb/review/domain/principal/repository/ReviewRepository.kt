package com.fnb.review.domain.principal.repository

import com.fnb.review.domain.principal.entity.ReviewEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface ReviewRepository : JpaRepository<ReviewEntity, Long> {
    fun findByRestaurantId(restaurantId: Long): MutableList<ReviewEntity>
    fun findByRestaurantIdAndReviewId(restaurantId: Long, reviewId: Long): Optional<ReviewEntity>
}