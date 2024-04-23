package cbconnectit.portfolio.web.data.models.dto.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JobPositionDto(
    val id: String = "",
    val name: String = "",
    @SerialName("created_at")
    val createdAt: String = "",
    @SerialName("updated_at")
    val updatedAt: String = ""
)
