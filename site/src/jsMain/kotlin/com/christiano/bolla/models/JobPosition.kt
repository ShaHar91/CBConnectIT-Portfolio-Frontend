package com.christiano.bolla.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JobPosition(
    val id: String,
    val name: String,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("updated_at")
    val updatedAt: String
)
