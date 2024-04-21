package com.christiano.bolla.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Testimonial(
    val id: String,
    @SerialName("image_url")
    val imageUrl: String,
    @SerialName("full_name")
    val fullName: String,
    val company: Company,
    @SerialName("job_position")
    val jobPosition: JobPosition,
    val review: String,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("updated_at")
    val updatedAt: String
)