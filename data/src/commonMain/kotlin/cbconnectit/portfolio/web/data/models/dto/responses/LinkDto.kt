package cbconnectit.portfolio.web.data.models.dto.responses

import androidx.compose.runtime.Composable
import cbconnectit.portfolio.web.data.models.enums.LinkType
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.components.icons.fa.FaGooglePlay
import com.varabyte.kobweb.silk.components.icons.fa.FaLinkedin
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LinkDto(
    val id: String,
    val url: String,
    val type: LinkType,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("updated_at")
    val updatedAt: String
)
