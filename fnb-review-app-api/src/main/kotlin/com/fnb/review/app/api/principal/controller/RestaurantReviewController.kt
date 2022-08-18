package com.fnb.review.app.api.principal.controller

import com.fnb.review.app.api.principal.model.ReviewSimpleDto
import com.fnb.review.app.api.principal.service.ReviewSearchService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/restaurants")
class RestaurantReviewController(
    val reviewSearchService: ReviewSearchService
) {

    @RequestMapping("/{restaurantId}/reviews/{reviewId}")
    fun review(@PathVariable("restaurantId") restaurantId: Long, @PathVariable("reviewId") reviewId: Long): ResponseEntity<ReviewSimpleDto> {
        return ResponseEntity.ok(
            reviewSearchService.findByRestaurantIdAndReviewId(restaurantId, reviewId)
        )
    }

    @RequestMapping("/{restaurantId}/reviews")
    fun reviews(@PathVariable("restaurantId") restaurantId: Long): ResponseEntity<List<ReviewSimpleDto>> {
        return ResponseEntity.ok(
            reviewSearchService.findByRestaurantId(restaurantId)
        )
    }
}