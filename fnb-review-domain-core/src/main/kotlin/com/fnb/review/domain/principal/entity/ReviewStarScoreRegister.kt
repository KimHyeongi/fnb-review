package com.fnb.review.domain.principal.entity

import org.hibernate.annotations.Comment
import org.jetbrains.annotations.NotNull
import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(
    name = "review_star_score_register",
)
@org.hibernate.annotations.Table(appliesTo = "review_star_score_register", comment = "별정 등록 유저")
class ReviewStarScoreRegister (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long = 0,

    @Column(nullable = false, name = "star_score", columnDefinition="Decimal(2,1) default '5.0'")
    @Comment(value = "사용자 별점")
    @NotNull
    val starScore: BigDecimal,

    @ManyToOne
    @JoinColumn(name = "review_id", insertable = false, updatable = false)
    val review: ReviewEntity

)