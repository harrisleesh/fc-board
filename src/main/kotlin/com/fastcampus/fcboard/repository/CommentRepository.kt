package com.fastcampus.fcboard.repository

import com.fastcampus.fcboard.domain.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Long>
