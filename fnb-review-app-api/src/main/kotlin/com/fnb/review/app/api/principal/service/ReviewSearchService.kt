package com.fnb.review.app.api.principal.service

import com.fnb.review.app.api.principal.model.ReviewSimpleDto
import com.fnb.review.app.api.principal.model.ReviewSimpleMapper
import com.fnb.review.domain.principal.service.ReviewQueryService
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class ReviewSearchService(val reviewQueryService: ReviewQueryService) {

    fun findByRestaurantIdAndReviewId(restaurantId: Long, reviewId: Long): ReviewSimpleDto{
        val review = reviewQueryService.findByRestaurantIdAndReviewId(reviewId);
        return ReviewSimpleMapper.map(review);
    }

    fun findByRestaurantId(restaurantId: Long): List<ReviewSimpleDto> {
        return reviewQueryService.findByRestaurantId(restaurantId)
            .stream()
            .map { it->ReviewSimpleMapper.map(it) }
            .collect(Collectors.toList())
    }
}