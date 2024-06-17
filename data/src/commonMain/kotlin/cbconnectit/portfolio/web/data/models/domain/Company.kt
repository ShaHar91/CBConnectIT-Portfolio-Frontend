package cbconnectit.portfolio.web.data.models.domain

import cbconnectit.portfolio.web.data.models.dto.responses.CompanyDto

data class Company(
    val id: String,
    val name: String,
    val links: List<Link>,
    val createdAt: String,
    val updatedAt: String
)

fun CompanyDto.toCompany() = Company(
    id,
    name,
    links.map { it.toLink() },
    createdAt,
    updatedAt
)