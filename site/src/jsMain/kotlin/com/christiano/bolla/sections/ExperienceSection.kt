package com.christiano.bolla.sections

import androidx.compose.runtime.*
import com.christiano.bolla.components.ExperienceCard
import com.christiano.bolla.components.SectionTitle
import com.christiano.bolla.components.Spacer
import com.christiano.bolla.models.Experience
import com.christiano.bolla.models.Section
import com.christiano.bolla.utils.Config
import com.christiano.bolla.utils.Constants
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.http.http
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.window
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun ExperienceSection() {
    Box(
        modifier = Modifier
            .id(Section.Experience.id)
            .scrollMargin(80.px)
            .fillMaxWidth()
            .maxWidth(Constants.SECTION_WIDTH.px),
        contentAlignment = Alignment.Center
    ) {
        ExperienceContent()
    }
}

@Composable
fun ExperienceContent() {
    val breakpoint = rememberBreakpoint()
    var experiences by remember { mutableStateOf(emptyList<Experience>()) }

    LaunchedEffect(Unit) {
        val responseText = window.http.get("${Config.baseUrl}/api/v1/experiences").decodeToString()
        experiences = Json.decodeFromString(responseText)
    }

    Column(
        modifier = Modifier.fillMaxWidth(if (breakpoint >= Breakpoint.MD) 80.percent else 90.percent),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier
                .fillMaxWidth(),
            section = Section.Experience,
            alignment = Alignment.CenterHorizontally,
            href = null // TODO: add navigation
//            showSeeAllButton = true
        )

        Spacer(Modifier.height(25.px))

        Column {
            experiences.forEachIndexed { index, experience ->
                ExperienceCard(breakpoint, index == 0, experience)
            }
        }
    }
}