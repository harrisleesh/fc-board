package com.fastcampus.fcboard.repository

import com.fastcampus.fcboard.domain.Tag
import org.springframework.data.jpa.repository.JpaRepository

interface TagRepository : JpaRepository<Tag, Long> {
    fun findByPostId(postId: Long): List<Tag>
}
