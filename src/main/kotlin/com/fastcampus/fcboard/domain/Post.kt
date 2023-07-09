package com.fastcampus.fcboard.domain

import com.fastcampus.fcboard.exception.PostNotUpdatableException
import com.fastcampus.fcboard.service.dto.PostUpdateRequestDto
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
class Post(
    createdBy: String,
    title: String,
    content: String,
    tags: List<String> = emptyList(),
) : BaseEntity(createdBy) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    var title: String = title
        protected set
    var content: String = content
        protected set

    @OneToMany(mappedBy = "post", orphanRemoval = true, cascade = [CascadeType.ALL])
    var comments: MutableList<Comment> = mutableListOf()
        protected set

    @OneToMany(mappedBy = "post", orphanRemoval = true, cascade = [CascadeType.ALL])
    var tags: MutableList<Tag> = tags.map { Tag(it, this, createdBy) }.toMutableList()
        protected set

    fun update(postUpdateRequestDto: PostUpdateRequestDto) {
        if (postUpdateRequestDto.updatedBy != this.createdBy) {
            throw PostNotUpdatableException()
        }
        this.title = postUpdateRequestDto.title
        this.content = postUpdateRequestDto.content
        replaceTags(postUpdateRequestDto.tags)
        super.updatedBy(postUpdateRequestDto.updatedBy)
    }

    private fun replaceTags(tags: List<String>) {
        if (this.tags.map { it.name } != tags) {
            this.tags.clear()
            this.tags.addAll(tags.map { Tag(it, this, this.createdBy) })
        }
    }
}
