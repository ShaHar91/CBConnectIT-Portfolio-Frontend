package com.christiano.bolla.models

import androidx.compose.runtime.Composable
import com.christiano.bolla.svg.phoneAndroidSvg
import com.christiano.bolla.svg.tvAndroidSvg
import com.varabyte.kobweb.compose.ui.Modifier
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.internal.JSJoda.DateTimeFormatter
import kotlinx.datetime.toInstant
import kotlinx.datetime.toJSDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jetbrains.compose.web.css.CSSColorValue

@Serializable
data class Experience(
    val id: String,
    @SerialName("short_description")
    val shortDescription: String,
    val description: String,
    val from: String,
    val to: String,
    val tags: List<Tag>,
    @SerialName("as_freelance")
    val asFreelance: Boolean,
    @SerialName("job_position")
    val jobPosition: JobPosition,
    val company: Company,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("updated_at")
    val updatedAt: String
) {

    val formattedDate: String
        get() = run {
            val localeOptions = dateLocaleOptions {
                month = "short"
                year = "numeric"
            }

            val fromDateFormatted = LocalDateTime.parse(from).toInstant(TimeZone.UTC).toJSDate().toLocaleString("en", localeOptions)
            val toDateFormatted = LocalDateTime.parse(to).toInstant(TimeZone.UTC).toJSDate().toLocaleString("en", localeOptions)

            "$fromDateFormatted - $toDateFormatted"
        }

    @Composable
    fun techStackSvg(
        tag: Tag,
        fill: CSSColorValue,
        modifier: Modifier = Modifier
    ) = when (tag.slug) {
        "android" -> phoneAndroidSvg(fill, modifier)
        "android-tv" -> tvAndroidSvg(fill, modifier)
        else -> Unit
    }
}