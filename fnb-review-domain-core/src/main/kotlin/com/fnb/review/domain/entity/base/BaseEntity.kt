package com.fnb.review.domain.entity.base

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
class BaseEntity(
    @CreatedDate @Column(name = "created_dt",
        nullable = false,
        updatable = false,
        columnDefinition = "DATE")
    val createdDt: LocalDateTime = LocalDateTime.now(),
    @LastModifiedDate @Column(name = "updated_dt", columnDefinition = "DATE")
    val updatedDt: LocalDateTime = LocalDateTime.now(),
    @CreatedBy @Column(name = "created_by", updatable = false)
    val createBy: Long = 1L,
    @LastModifiedBy @Column(name = "updated_by")
    val updatedBy: Long = 1L,
    @Column(name = "deleted")
    var deleted: Boolean = false
)
