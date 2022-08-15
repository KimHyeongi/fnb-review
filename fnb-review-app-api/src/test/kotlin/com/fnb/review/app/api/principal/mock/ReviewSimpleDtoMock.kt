package com.fnb.review.app.api.principal.mock

import com.fnb.review.app.api.principal.model.ReviewSimpleDto

internal object ReviewSimpleDtoMock {

    fun reviewSimpleDto(
        id: Long = 1,
        contents: String = "Review",
        stars: Double = 5.0
    ) = ReviewSimpleDto(
        id = id, contents = contents, stars = stars
    )

}