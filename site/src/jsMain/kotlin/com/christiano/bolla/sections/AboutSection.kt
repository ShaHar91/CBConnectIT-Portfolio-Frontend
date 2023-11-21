package com.christiano.bolla.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.christiano.bolla.components.HighLightCard
import com.christiano.bolla.components.SectionTitle
import com.christiano.bolla.components.Spacer
import com.christiano.bolla.models.Section
import com.christiano.bolla.styles.onSecondaryContainer
import com.christiano.bolla.styles.onSurface
import com.christiano.bolla.styles.secondaryContainer
import com.christiano.bolla.svg.completedProjectsSvg
import com.christiano.bolla.svg.experienceSvg
import com.christiano.bolla.utils.Constants
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import kotlin.js.Date
import kotlin.time.DurationUnit
import kotlin.time.toDuration

@Composable
fun AboutSection() {
    Box(
        modifier = Modifier
            .id(Section.About.id)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        AboutContent()
    }
}

@Composable
fun AboutContent() {
    val colorMode by ColorMode.currentState

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .color(colorMode.toPalette().onSecondaryContainer)
            .backgroundColor(colorMode.toPalette().secondaryContainer)
            .padding(topBottom = 32.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier.fillMaxWidth(),
            section = Section.About,
            alignment = Alignment.CenterHorizontally
        )

        Spacer(Modifier.height(36.px))

        P(
            attrs = Modifier
                .fillMaxWidth(80.percent)
                .maxWidth(780.px)
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(16.px)
                .textAlign(TextAlign.Center)
                .fontWeight(FontWeight.Normal)
                .toAttrs()
        ) {
            Text("Skilled Android Developer with developing applications using Java and Kotlin since 2017. Someone who has a passion for staying up-to-date with all new technologies, constantly seeking to explore and take advantage of the latest advancements in the Android Framework. Committed to delivering robust, user-friendly, and scalable applications. A fast learner with an ability to adapt quickly to new technologies and a strong focus for code quality and best practices.")
        }

        Spacer(Modifier.height(36.px))

        Row {
            val started = Date.UTC(2017, 11).toDuration(DurationUnit.MILLISECONDS)
            val current = Date.now().toDuration(DurationUnit.MILLISECONDS)

            val yearsExperience = (current - started).inWholeDays / 365

            HighLightCard(colorMode, "Experience", "$yearsExperience+ years") {
                experienceSvg(colorMode.toPalette().onSurface)
            }

            Spacer(Modifier.width(16.px))

            HighLightCard(colorMode, "Completed", "15+ projects") {
                completedProjectsSvg(colorMode.toPalette().onSurface)
            }
        }
    }
}
