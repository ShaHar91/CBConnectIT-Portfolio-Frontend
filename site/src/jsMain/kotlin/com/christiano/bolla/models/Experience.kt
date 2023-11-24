package com.christiano.bolla.models

import androidx.compose.runtime.Composable
import com.christiano.bolla.svg.phoneAndroidSvg
import com.christiano.bolla.svg.tvAndroidSvg
import com.varabyte.kobweb.compose.ui.Modifier
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toJSDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jetbrains.compose.web.css.CSSColorValue

@Serializable
data class Experience(
    val id: String,
    @SerialName("job_position")
    val jobPosition: String,
    @SerialName("short_description")
    val shortDescription: String,
    val description: String,
    val company: String,
    val from: String,
    val to: String,
    @SerialName("tech_stack")
    val techStack: List<TechStack>
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
}

enum class TechStack {
    Android,
    AndroidTV;

    @Composable
    fun techStackSvg(
        fill: CSSColorValue,
        modifier: Modifier = Modifier,
    ) = when (this) {
        Android -> phoneAndroidSvg(fill, modifier)
        AndroidTV -> tvAndroidSvg(fill, modifier)
    }
}
