package com.fnb.review.domain.db.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories(
    basePackages = ["com.fnb.review.domain"]
)
@EntityScan(
    basePackages = ["com.fnb.review.domain"]
)
class JpaConfig