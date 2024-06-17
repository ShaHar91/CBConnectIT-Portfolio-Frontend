package cbconnectit.portfolio.web.data.models.domain

import cbconnectit.portfolio.web.data.models.dto.responses.TagDto

data class Tag(
    val id: String,
    val name: String,
    val slug: String,
    val createdAt: String,
    val updatedAt: String
)

fun TagDto.toTag() = Tag(
    id,
    name,
    slug,
    createdAt,
    updatedAt
)