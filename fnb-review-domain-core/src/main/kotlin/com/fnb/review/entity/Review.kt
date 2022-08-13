package com.fnb.review.entity

import com.fnb.review.entity.base.BaseEntity
import org.jetbrains.annotations.NotNull
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Review(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    @NotNull val contents: String
    ): BaseEntity()