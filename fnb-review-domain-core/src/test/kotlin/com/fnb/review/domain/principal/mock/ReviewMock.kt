package com.fnb.review.domain.principal.mock

import com.fnb.review.domain.principal.entity.ReviewEntity

internal object ReviewMock {

    fun review(
        id: Long = 1,
        contents: String = "Review"
    ) = ReviewEntity(
        id = id, contents = contents, stars = 5.0
    )
}