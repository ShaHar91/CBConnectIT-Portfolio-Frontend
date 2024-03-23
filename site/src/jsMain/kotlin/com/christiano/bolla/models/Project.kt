package com.christiano.bolla.models

import com.christiano.bolla.utils.Constants
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Project(
    val id: String,
    @SerialName("banner_image_url")
    val bannerImageUrl: String,
    @SerialName("image_url")
    val imageUrl: String,
    val title: String,
    @SerialName("short_description")
    val shortDescription: String,
    val description: String,
    val links: List<Link>,
    val tags: List<Tag>,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("updated_at")
    val updatedAt: String
)

enum class Social(val link: String, val type: LinkType) {
    Github(Constants.GITHUB_LINK_PERSONAL, LinkType.Github),
    LinkedIn(Constants.LINKED_IN_LINK_PERSONAL, LinkType.LinkedIn)
}