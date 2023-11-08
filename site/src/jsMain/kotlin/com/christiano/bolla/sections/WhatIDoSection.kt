package com.christiano.bolla.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.christiano.bolla.components.Backdrop
import com.christiano.bolla.components.HighLightCard
import com.christiano.bolla.components.SectionTitle
import com.christiano.bolla.models.Section
import com.christiano.bolla.utils.Constants
import com.christiano.bolla.utils.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaAward
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.toSilkPalette
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import kotlin.js.Date
import kotlin.time.DurationUnit
import kotlin.time.toDuration

@Composable
fun WhatIDoSection() {
    Box(
        modifier = Modifier
            .id(Section.About.id)
            .fillMaxWidth()
            .margin(top = Constants.SECTION_PADDING.px)
            .padding(top = 50.px),
        contentAlignment = Alignment.Center
    ) {
        WhatIDoContent()
    }
}

@Composable
fun WhatIDoContent() {
    val colorMode by ColorMode.currentState

    val alwaysDarkMode = colorMode.let {
        if (it.isDark) it else it.opposite
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .color(alwaysDarkMode.toSilkPalette().color)
            .backgroundColor(Color.rgb(99, 116, 140))
            .padding(topBottom = 50.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier,
            section = Section.About,
            alignment = Alignment.CenterHorizontally
        )

        P(
            attrs = Modifier
                .margin(topBottom = 25.px, leftRight = 50.px)
                .maxWidth(1200.px)
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(18.px)
                .textAlign(TextAlign.Center)
                .fontWeight(FontWeight.Normal)
                .toAttrs()
        ) {
            Text("Skilled Android Developer with over 5 years of experience in developing applications using Java and Kotlin. Someone who has a passion for staying up-to-date with all new technologies, constantly seeking to explore and take advantage of the latest advancements in the Android Framework. Committed to delivering robust, user-friendly, and scalable applications. A fast learner with an ability to adapt quickly to new technologies and a strong focus for code quality and best practices.")
        }

        Row {
            val started = Date.UTC(2017, 11).toDuration(DurationUnit.MILLISECONDS)
            val current = Date.now().toDuration(DurationUnit.MILLISECONDS)

            val yearsExperience = (current - started).inWholeDays / 365

            HighLightCard(alwaysDarkMode.opposite, "Experience", "$yearsExperience+ years")
            HighLightCard(alwaysDarkMode.opposite, "Completed", "15+ projects", modifier = Modifier.margin(right = 10.px, left = 10.px))
            HighLightCard(alwaysDarkMode.opposite, "Something", "Dunno yet")
        }
    }
}
