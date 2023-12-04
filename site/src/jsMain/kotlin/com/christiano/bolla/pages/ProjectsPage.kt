package com.christiano.bolla.pages

import androidx.compose.runtime.*
import com.christiano.bolla.components.*
import com.christiano.bolla.models.Project
import com.christiano.bolla.styles.onSecondaryContainer
import com.christiano.bolla.styles.secondaryContainer
import com.christiano.bolla.utils.Constants
import com.christiano.bolla.utils.markdownParagraph
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.http.http
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import kotlinx.browser.window
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.H3

@Page("/projects")
@Composable
fun ProjectsPage() {
    var menuOpened by remember { mutableStateOf(false) }
    val breakpoint = rememberBreakpoint()
    var projects by remember { mutableStateOf<List<Project>>(emptyList()) }

    LaunchedEffect(Unit) {
        val responseText = window.http.get("/api/works.json").decodeToString()
        projects = Json.decodeFromString<List<Project>>(responseText)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        PageLayout(
            "Projects",
            false,
            {
                menuOpened = true
            }
        ) {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                H1(
                    attrs = Modifier
                        .fillMaxWidth()
                        .toAttrs()
                ) {
                    Text("Projects")
                }

                ProjectsList(breakpoint, projects)
            }
        }

//        * var showModal by remember { mutableStateOf(true) }
//        * if (showModal) {
//        *   Overlay(Modifier.onClick { showModal = false }) {
//            *     Dialog {
//            *        // ... your modal content here ...
//            *     }
//            *   }
//        * }

        BackToTopButton()

        if (menuOpened) {
            OverlowMenu { menuOpened = false }
        }
    }
}

@Composable
private fun ProjectsList(breakpoint: Breakpoint, projects: List<Project>) {
    projects.forEachIndexed { index, project ->
        val leftAligned = index % 2 == 0

        if (index != 0) {
            Spacer(Modifier.height(68.px))
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .thenIf(leftAligned.not()) {
                    Modifier.backgroundColor(ColorMode.current.toPalette().secondaryContainer)
                        .color(ColorMode.current.toPalette().onSecondaryContainer)
                }
                .display(DisplayStyle.Flex)
                .flexDirection(if (breakpoint > Breakpoint.MD) FlexDirection.Row else FlexDirection.Column)
                .alignItems(AlignItems.Center)
                .padding(topBottom = 50.px, leftRight = 10.percent)
        ) {
            if (leftAligned && breakpoint > Breakpoint.MD) {
                ProjectImageWithLinks(breakpoint, project)

                Spacer(Modifier.width(100.px))
            }

            Column(
                Modifier.fillMaxWidth()
            ) {
                P(
                    attrs = Modifier
                        .fontSize(32.px)
                        .fontWeight(FontWeight.Bold)
                        .fontFamily(Constants.FONT_FAMILY)
                        .toAttrs()
                ) {
                    Text(project.title)
                }

                P(
                    attrs = Modifier
                        .fontSize(18.px)
                        .fontFamily(Constants.FONT_FAMILY)
                        .toAttrs {
                            markdownParagraph(project.description)
                        }
                )

                Box(
                    Modifier
                        .fillMaxWidth()
                        .display(DisplayStyle.Flex)
                        .flexDirection(FlexDirection.Row)
                        .flexWrap(FlexWrap.Wrap)
                        .gap(12.px)
                ) {
                    project.tags.forEach {
                        P(
                            Modifier
                                .padding(topBottom = 4.px, leftRight = 6.px)
                                .margin(topBottom = 0.px)
                                .backgroundColor(ColorMode.current.toPalette().secondaryContainer)
                                .color(ColorMode.current.toPalette().onSecondaryContainer)
                                .fontSize(11.px)
                                .borderRadius(6.px)
                                .toAttrs()
                        ) { Text(it.name) }
                    }
                }
            }

            if (leftAligned.not() || breakpoint <= Breakpoint.MD) {
                Spacer(Modifier
                    .width(100.px)
                    .thenIf(breakpoint <= Breakpoint.MD) {
                        Modifier.height(40.px)
                    })

                ProjectImageWithLinks(breakpoint, project)
            }
        }
    }
}

@Composable
private fun ProjectImageWithLinks(breakpoint: Breakpoint, project: Project) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(modifier = Modifier.width(250.px), src = project.image, alt = "")

        Spacer(Modifier.height(36.px))

        SocialBar(true, links = project.links, itemGap = 20.px, socialLinkSize = SocialLinkSize.LG)
    }
}