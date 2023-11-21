package com.christiano.bolla.models

import kotlinx.serialization.Serializable

@Serializable
data class Project(
    val id: String,
    val banner_image: String,
    val image: String,
    val title: String,
    val short_description: String,
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