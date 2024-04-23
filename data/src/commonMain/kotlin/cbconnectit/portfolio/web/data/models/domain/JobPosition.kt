package cbconnectit.portfolio.web.data.models.domain

import cbconnectit.portfolio.web.data.models.dto.responses.JobPositionDto

data class JobPosition(
    val id: String,
    val name: String,
    val createdAt: String,
    val updatedAt: String
)

fun JobPositionDto.toJobPosition() = JobPosition(
    id,
    name,
    createdAt,
    updatedAt
)
