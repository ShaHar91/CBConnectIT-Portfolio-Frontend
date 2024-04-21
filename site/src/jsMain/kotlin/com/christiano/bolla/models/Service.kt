package com.christiano.bolla.models

import androidx.compose.runtime.Composable
import com.christiano.bolla.svg.*
import com.christiano.bolla.utils.Res
import com.varabyte.kobweb.compose.ui.Modifier
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jetbrains.compose.web.css.CSSColorValue

@Serializable
data class Service(
    val id: String,
    @SerialName("image_url")
    val imageUrl: String,
    val title: String,
    @SerialName("short_description")
    val shortDescription: String? = null,
    val description: String,
    @SerialName("banner_description")
    val bannerDescription: String? = null,
    @SerialName("sub_services")
    val subServices: List<Service>? = null,
    @SerialName("extra_info")
    val extraInfo: String? = null,
    val tag: Tag? = null,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("updated_at")
    val updatedAt: String
) {
    @Composable
    fun getServiceTypeIcon(
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

    val typeImage get() = run {
        when {
            title.lowercase().startsWith("mobile") -> Res.Image.servicesMobile
            title.lowercase().startsWith("web") -> Res.Image.servicesWeb
            title.lowercase().startsWith("backend") -> Res.Image.servicesBackend
            title.lowercase().startsWith("tutoring") -> Res.Image.servicesTutoring
            else -> ""
        }
    }
}

@Serializable
data class Tag(
    val id: String,
    val name: String,
    val slug: String,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("updated_at")
    val updatedAt: String
)