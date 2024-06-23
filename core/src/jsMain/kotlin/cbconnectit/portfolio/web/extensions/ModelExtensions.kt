package cbconnectit.portfolio.web.extensions

import androidx.compose.runtime.Composable
import cbconnectit.portfolio.web.data.models.domain.Experience
import cbconnectit.portfolio.web.data.models.domain.Service
import cbconnectit.portfolio.web.data.models.domain.Tag
import cbconnectit.portfolio.web.svg.*
import cbconnectit.portfolio.web.utils.Res
import com.varabyte.kobweb.compose.ui.Modifier
import org.jetbrains.compose.web.css.CSSColorValue

@Composable
fun Experience.techStackSvg(
    tag: Tag,
    fill: CSSColorValue,
    modifier: Modifier = Modifier
) = when (tag.slug) {
    "android" -> phoneAndroidSvg(fill, modifier)
    "android-tv" -> tvAndroidSvg(fill, modifier)
    else -> Unit
}

@Composable
fun Service.getServiceTypeIcon(
    fill: CSSColorValue,
    modifier: Modifier = Modifier,
) {
    when {
        title.lowercase().startsWith("mobile") -> mobileDevelopmentSvg(fill, modifier)
        title.lowercase().startsWith("web") -> frontendDevelopmentSvg(fill, modifier)
        title.lowercase().startsWith("backend") -> backendDevelopmentSvg(fill, modifier)
        title.lowercase().startsWith("tutoring") -> tutoringSvg(fill, modifier)
    }
}