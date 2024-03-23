package com.christiano.bolla.models

import androidx.compose.runtime.Composable
import com.christiano.bolla.utils.Constants
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.components.icons.fa.FaGooglePlay
import com.varabyte.kobweb.silk.components.icons.fa.FaLinkedin
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Project(
    val id: String,
    @SerialName("banner_image")
    val bannerImage: String,
    val image: String,
    val title: String,
    @SerialName("short_description")
    val shortDescription: String,
    val description: String,
    val links: List<LinkOld>,
    val tags: List<TagOld>
)

@Serializable
data class LinkOld(
    val type: LinkType,
    val url: String
)

@Serializable
data class TagOld(
    val id: String,
    val name: String
)


enum class Social(val link: String, val type: LinkType) {
    Github(Constants.GITHUB_LINK_PERSONAL, LinkType.Github),
    LinkedIn(Constants.LINKED_IN_LINK_PERSONAL, LinkType.LinkedIn)
}