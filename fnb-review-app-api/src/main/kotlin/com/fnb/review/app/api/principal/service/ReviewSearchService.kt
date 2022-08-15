package com.fnb.review.app.api.principal.service

import com.fnb.review.app.api.principal.model.ReviewSimpleDto
import com.fnb.review.app.api.principal.model.ReviewSimpleMapper
import com.fnb.review.domain.principal.service.ReviewQueryService
import org.springframework.stereotype.Service

@Service
class ReviewSearchService(val reviewQueryService: ReviewQueryService) {

    fun findOne(id: Long): ReviewSimpleDto{
        val review = reviewQueryService.findById(id);
        return ReviewSimpleMapper.map(review);
    }
}