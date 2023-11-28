package com.christiano.bolla.models

import androidx.compose.runtime.Composable
import com.christiano.bolla.styles.primary
import com.christiano.bolla.svg.mobileDevelopmentSvg
import com.christiano.bolla.svg.overflowMenuSvg
import com.christiano.bolla.svg.tutoringSvg
import com.christiano.bolla.utils.Res
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jetbrains.compose.web.css.CSSColorValue

@Serializable
data class Service(
    val id: String,
    val image: String,
    val title: String,
    @SerialName("short_description")
    val shortDescription: String,
    val description: String,
    @SerialName("banner_description")
    val bannerDescription: String,
    val type: ServiceType,
    @SerialName("sub_services")
    val subServices: List<SubService>? = null,
    @SerialName("extra_info")
    val extraInfo: String? = null
)

@Serializable
data class SubService(
    val title: String,
    val description: String,
    val image: String? = null,
    @SerialName("sub_type")
    val subType: ServiceSubType,
    val tag: Tag
)

enum class ServiceType(val image: String, val id: String, val path: String) {
    Mobile(Res.Icon.servicesMobile, "mobile", "#mobile"),
    Web(Res.Icon.servicesMobile, "web", "#web"),
    Tutoring(Res.Icon.servicesTutoring, "tutoring", "#tutoring");

    @Composable
    fun getServiceTypeIcon(
        fill: CSSColorValue,
        modifier: Modifier = Modifier,
    ) {
        when (this) {
            Mobile -> mobileDevelopmentSvg(fill, modifier)
            Tutoring -> tutoringSvg(fill, modifier)
            Web -> overflowMenuSvg(fill, modifier)
        }
    }
}

enum class ServiceSubType {
    Android,
    iOS,
    KMP,
    Flutter,
    Placeholder
}

