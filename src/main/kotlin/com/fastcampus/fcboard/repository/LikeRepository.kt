package com.fastcampus.fcboard.repository

import com.fastcampus.fcboard.domain.Like
import org.springframework.data.jpa.repository.JpaRepository

interface LikeRepository : JpaRepository<Like, Long>
