package com.christiano.bolla.sections

import androidx.compose.runtime.*
import com.christiano.bolla.components.ContactForm
import com.christiano.bolla.components.SectionTitle
import com.christiano.bolla.models.Section
import com.christiano.bolla.utils.Constants
import com.christiano.bolla.utils.ObserveViewportEntered
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun ContactSection() {
    Box(
        modifier = Modifier
            .id(Section.Contact.id)
            .maxWidth(Constants.SECTION_WIDTH.px)
            .padding(topBottom = 100.px),
        contentAlignment = Alignment.Center
    ) {
        ContactContent()
    }
}

@OptIn(ExperimentalComposeWebApi::class)
@Composable
fun ContactContent() {
    val breakpoint = rememberBreakpoint()

    val scope = rememberCoroutineScope()
    var animatedRotation by remember { mutableStateOf(0.deg) }

    ObserveViewportEntered(
        sectionId = Section.Contact.id,
        distanceFromTop = 500.0
    ) {
        animatedRotation = 10.deg
        scope.launch {
            delay(500)
            animatedRotation = 0.deg
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 100.percent else 90.percent),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier
                .fillMaxWidth()
                .transform { rotate(animatedRotation) }
                .margin(bottom = 25.px)
                .transition(CSSTransition("transform", 500.ms)),
            section = Section.Contact,
            alignment = Alignment.CenterHorizontally
        )

        ContactForm(breakpoint)
    }
}