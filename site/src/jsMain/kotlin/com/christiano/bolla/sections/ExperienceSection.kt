package com.christiano.bolla.sections

import androidx.compose.runtime.*
import com.christiano.bolla.components.ExperienceCard
import com.christiano.bolla.components.ExperienceDescription
import com.christiano.bolla.components.ExperienceDetails
import com.christiano.bolla.components.SectionTitle
import com.christiano.bolla.models.Experience
import com.christiano.bolla.models.Section
import com.christiano.bolla.utils.Constants
import com.christiano.bolla.utils.ObserveViewportEntered
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun ExperienceSection() {
    Box(
        modifier = Modifier
            .id(Section.Experience.id)
            .maxWidth(Constants.SECTION_WIDTH.px)
            .padding(topBottom = 100.px),
        contentAlignment = Alignment.Center
    ) {
        ExperienceContent()
    }
}

@Composable
fun ExperienceContent() {
    val breakpoint = rememberBreakpoint()
    var animatedMargin by remember { mutableStateOf(200.px) }

    ObserveViewportEntered(
        sectionId = Section.Experience.id,
        distanceFromTop = 500.0
    ) {
        animatedMargin = 50.px
    }

    Column(
        modifier = Modifier
            .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 100.percent else 80.percent),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier
                .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 60.percent else 90.percent)
                .margin(bottom = 25.px),
            section = Section.Experience,
        )

        Experience.values().forEach {
            ExperienceCard(breakpoint, it == Experience.values()[0], it, animatedMargin)
        }
    }
}