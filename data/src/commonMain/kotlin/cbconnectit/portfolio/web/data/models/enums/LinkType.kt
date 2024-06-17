package cbconnectit.portfolio.web.data.models.enums

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.components.icons.fa.FaGooglePlay
import com.varabyte.kobweb.silk.components.icons.fa.FaLinkedin
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import kotlinx.serialization.Serializable

@Serializable
enum class LinkType {
    Github,
    LinkedIn,
    PlayStore,
    Unknown;
}

@Composable
fun LinkType.LinkIcon(
    modifier: Modifier = Modifier,
    size: IconSize = IconSize.SM,
) {
    when (this) {
        LinkType.Github -> FaGithub(modifier = modifier, size)
        LinkType.LinkedIn -> FaLinkedin(modifier = modifier, size)
        LinkType.PlayStore -> FaGooglePlay(modifier = modifier, size)
        LinkType.Unknown -> Unit
    }
}
