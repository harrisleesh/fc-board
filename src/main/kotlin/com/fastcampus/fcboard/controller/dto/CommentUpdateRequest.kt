package com.fastcampus.fcboard.controller.dto

data class CommentUpdateRequest(
    val content: String,
    val updatedBy: String,
)
