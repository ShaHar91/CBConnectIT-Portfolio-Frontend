package cbconnectit.portfolio.web.data.models.dto.responses

import cbconnectit.portfolio.web.data.models.enums.LinkType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProjectDto(
    val id: String,
    @SerialName("banner_image_url")
    val bannerImageUrl: String,
    @SerialName("image_url")
    val imageUrl: String,
    val title: String,
    @SerialName("short_description")
    val shortDescription: String,
    val description: String,
    val links: List<LinkDto>,
    val tags: List<TagDto>,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("updated_at")
    val updatedAt: String
)
