package cbconnectit.portfolio.web.data.models.dto.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExperienceDto(
    val id: String,
    @SerialName("short_description")
    val shortDescription: String,
    val description: String,
    val from: String,
    val to: String,
    val tags: List<TagDto>,
    @SerialName("as_freelance")
    val asFreelance: Boolean,
    @SerialName("job_position")
    val jobPosition: JobPositionDto,
    val company: CompanyDto,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("updated_at")
    val updatedAt: String
)