package com.fnb.review.domain.principal.repository

import com.fnb.review.domain.principal.entity.ReviewEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository : JpaRepository<ReviewEntity, Long> {
}