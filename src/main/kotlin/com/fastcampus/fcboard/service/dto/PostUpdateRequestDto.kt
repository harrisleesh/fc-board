package com.fastcampus.fcboard.service.dto

data class PostUpdateRequestDto(
    val title: String,
    val content: String,
    val updatedBy: String,
    val tags: List<String> = emptyList(),
)
