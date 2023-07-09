package com.fastcampus.fcboard.controller.dto

import com.fastcampus.fcboard.service.dto.PostCreateRequestDto

data class PostCreateRequest(
    val title: String,
    val content: String,
    val createdBy: String,
    val tags: List<String> = emptyList(),
)

fun PostCreateRequest.toDto() = PostCreateRequestDto(
    title = title,
    content = content,
    createdBy = createdBy,
    tags = tags
)
