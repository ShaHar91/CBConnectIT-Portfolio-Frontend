package cbconnectit.portfolio.web.data.models.domain

import cbconnectit.portfolio.web.data.models.dto.responses.ExperienceDto
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toJSDate


data class Experience(
    val id: String,
    val shortDescription: String,
    val description: String,
    val from: String,
    val to: String,
    val tags: List<Tag>,
    val asFreelance: Boolean,
    val jobPosition: JobPosition,
    val company: Company,
    val createdAt: String,
    val updatedAt: String
) {

    val formattedDate: String
        get() = run {
            val localeOptions = dateLocaleOptions {
                month = "short"
                year = "numeric"
            }

            val fromDateFormatted = LocalDateTime.parse(from).toInstant(TimeZone.UTC).toJSDate().toLocaleString("en", localeOptions)
            val toDateFormatted = LocalDateTime.parse(to).toInstant(TimeZone.UTC).toJSDate().toLocaleString("en", localeOptions)

            "$fromDateFormatted - $toDateFormatted"
        }

    val formattedJobPosition: String get() = run {
        val suffix = if (asFreelance) " (Freelance)" else ""

        jobPosition.name + suffix
    }
}

fun ExperienceDto.toExperience() = Experience(
    id,
    shortDescription,
    description,
    from,
    to,
    tags.map { it.toTag() },
    asFreelance,
    jobPosition.toJobPosition(),
    company.toCompany(),
    createdAt,
    updatedAt
)