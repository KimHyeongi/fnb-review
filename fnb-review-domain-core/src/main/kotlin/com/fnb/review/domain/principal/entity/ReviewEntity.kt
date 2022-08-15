package com.fnb.review.domain.principal.entity

import com.fnb.review.domain.entity.base.BaseEntity
import org.hibernate.annotations.Comment
import org.jetbrains.annotations.NotNull
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Index
import javax.persistence.Table

@Entity
@Table(
    name = "review",
    indexes = [
        Index(name = "idx_review_stars", columnList = "stars", unique = false)
        // ,Index(name = "idx_dic_multiple_columns", columnList = "word, xxxx")
    ]
)
@org.hibernate.annotations.Table(appliesTo = "dic", comment = "사전")
class ReviewEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long = 0,

    @Column(nullable = false, name = "contents", length = 4000)
    @Comment("리뷰 본문")
    @NotNull
    var contents: String,

    @Column(nullable = false, name = "stars", columnDefinition="Decimal(1,1) default '5.0'")
    @Comment(value = "사용자 별점")
    @NotNull
    var stars: Double
) : BaseEntity()