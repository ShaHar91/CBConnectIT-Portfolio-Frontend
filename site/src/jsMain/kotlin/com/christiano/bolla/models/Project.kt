package com.christiano.bolla.models

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
    val links: List<Link>,
    val tags: List<Tag>
)

@Serializable
data class Link(
    val type: String,
    val url: String
)

@Serializable
data class Tag(
    val id: String,
    val name: String
)