package cbconnectit.portfolio.web.data.models.domain

import cbconnectit.portfolio.web.data.models.dto.responses.TestimonialDto

data class Testimonial(
    val id: String,
    val imageUrl: String,
    val fullName: String,
    val company: Company?,
    val jobPosition: JobPosition,
    val review: String,
    val createdAt: String,
    val updatedAt: String
)

fun TestimonialDto.toTestimonial() = Testimonial(
    id,
    imageUrl,
    fullName,
    company?.toCompany(),
    jobPosition.toJobPosition(),
    review,
    createdAt,
    updatedAt
)