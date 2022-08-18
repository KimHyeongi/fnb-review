package com.fnb.review.domain.principal.entity

import com.fnb.review.domain.entity.base.BaseEntity
import org.hibernate.annotations.Comment
import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
@Table(
    name = "review",
    indexes = [
        Index(name = "idx_review_average_star_score", columnList = "average_star_score", unique = false)
        // ,Index(name = "idx_dic_multiple_columns", columnList = "word, xxxx")
    ]
)
@org.hibernate.annotations.Table(appliesTo = "review", comment = "사전")
class ReviewEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long = 0,

    @Column(nullable = false, name = "contents", length = 4000)
    @Comment("리뷰 본문")
    @NotNull
    var contents: String,

    @Column(nullable = false, name = "average_star_score", columnDefinition="Decimal(2,1) default '5.0'")
    @Comment(value = "사용자 별점")
    @NotNull
    var averageStarScore: Double,

    @Column(nullable = false, name = "restaurant_id")
    @Comment(value = "업장 ID")
    val restaurantId: Long,

    // Kotlin OneToMany의 처리 방식은 좀 더 고민이 필요함.
    @OneToMany(mappedBy = "review", fetch = FetchType.LAZY)
    var starScoreRegisters: MutableList<ReviewStarScoreRegister> = mutableListOf()
) : BaseEntity()