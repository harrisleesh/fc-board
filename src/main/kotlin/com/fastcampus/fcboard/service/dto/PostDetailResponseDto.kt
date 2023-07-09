package com.fastcampus.fcboard.service.dto

import com.fastcampus.fcboard.domain.Post

data class PostDetailResponseDto(
    val id: Long,
    val title: String,
    val content: String,
    val createdBy: String,
    val createdAt: String,
    val comments: List<CommentResponseDto>,
    val tags: List<String> = emptyList(),
    val likeCount: Long = 0,
)

fun Post.toDetailResponseDto(likeCount: Long) = PostDetailResponseDto(
    id = id,
    title = title,
    content = content,
    createdBy = createdBy,
    createdAt = createdAt.toString(),
    comments = comments.map { it.toResponseDto() },
    tags = tags.map { it.name },
    likeCount = likeCount
)
