package com.fastcampus.fcboard.controller.dto

data class PostSummaryResponse(
    val id: Long,
    val title: String,
    val createdBy: String,
    val createdAt: String,
)
