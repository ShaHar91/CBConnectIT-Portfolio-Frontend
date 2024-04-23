package cbconnectit.portfolio.web.data.models.domain

import cbconnectit.portfolio.web.data.models.dto.responses.LinkDto
import cbconnectit.portfolio.web.data.models.enums.LinkType

data class Link(
    val id: String,
    val url: String,
    val type: LinkType,
    val createdAt: String,
    val updatedAt: String
)

fun LinkDto.toLink() = Link(
    id,
    url,
    type,
    createdAt,
    updatedAt
)