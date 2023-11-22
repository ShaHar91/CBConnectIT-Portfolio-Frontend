package com.christiano.bolla.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Testimonial(
    val id: String,
    val image: String,
    @SerialName("full_name")
    val fullName: String,
    val function: String,
    val review: String
)