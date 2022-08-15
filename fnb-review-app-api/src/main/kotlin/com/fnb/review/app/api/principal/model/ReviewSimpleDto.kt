package com.fnb.review.app.api.principal.model

import com.fnb.review.domain.principal.entity.ReviewEntity

class ReviewSimpleDto(
    val id: Long,
    val contents: String,
    val stars: Double
)

object ReviewSimpleMapper{
    fun map(review: ReviewEntity): ReviewSimpleDto = review.let {
        return ReviewSimpleDto(id = it.id, contents = it.contents, stars = it.stars)
    }
}