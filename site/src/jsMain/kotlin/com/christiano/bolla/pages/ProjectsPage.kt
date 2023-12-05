package com.christiano.bolla.pages

import androidx.compose.runtime.*
import com.christiano.bolla.components.*
import com.christiano.bolla.models.Project
import com.christiano.bolla.models.Tag
import com.christiano.bolla.styles.*
import com.christiano.bolla.utils.Constants
import com.christiano.bolla.utils.Identifiers
import com.christiano.bolla.utils.markdownParagraph
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.http.http
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Checkbox
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaChevronDown
import com.varabyte.kobweb.silk.components.icons.fa.FaChevronUp
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import com.varabyte.kobweb.silk.theme.shapes.RectF
import com.varabyte.kobweb.silk.theme.shapes.clip
import kotlinx.browser.window
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLElement

@Page("/projects")
@Composable
fun ProjectsPage() {
    val ctx = rememberPageContext()
    var menuOpened by remember { mutableStateOf(false) }
    val breakpoint = rememberBreakpoint()
    var projects by remember { mutableStateOf<List<Project>>(emptyList()) }
    var showDropDownMenu by remember { mutableStateOf(false) }
    val queryTagIds = ctx.route.params.filterKeys { it.startsWith("tag") }.values.toList()
    var filterTags by remember { mutableStateOf<List<String>>(queryTagIds) }

    //TODO: Other pages should be able to link to this page with filterTags available from the get-go,

    window.onclick = {
        val targetIsNotDropDown = (it.target as? HTMLElement)?.id != Identifiers.ProjectsPage.dropBtn

        if (targetIsNotDropDown) {
            showDropDownMenu = false
        }
    }

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

                TitleAndDropDown(breakpoint, showDropDownMenu, projects, filterTags, {
                    val tempFilterTags = filterTags.toMutableList()
                    if (tempFilterTags.contains(it.id)) {
                        tempFilterTags.remove(it.id)
                    } else {
                        tempFilterTags.add(it.id)
                    }
                    filterTags = tempFilterTags
                }) {
                    showDropDownMenu = it
                }

                ProjectsList(breakpoint, projects.filter { it.tags.any { tag -> if (filterTags.isNotEmpty()) tag.id in filterTags else true } })
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
fun TitleAndDropDown(breakpoint: Breakpoint, showDropDownMenu: Boolean, projects: List<Project>, filterTags: List<String>, toggleFilterTag: (tag: Tag) -> Unit, toggleDropDownMenu: (Boolean) -> Unit) {
    Box(
        Modifier
            .fillMaxWidth()
            .maxWidth(Constants.SECTION_WIDTH.px),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(topBottom = 50.px, leftRight = 10.percent),
            horizontalAlignment = Alignment.Start
        ) {
            H1(
                attrs = Modifier
                    .fillMaxWidth()
                    .toAttrs()
            ) {
                Text("Projects")
            }

            Spacer(Modifier.height(8.px))

            Box(
                modifier = Modifier
                    .fillMaxWidth(if (breakpoint >= Breakpoint.SM) 60.percent else 100.percent)
                    .position(Position.Relative)
                    .display(DisplayStyle.InlineBlock),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    modifier = ProjectTagLinkStyle.toModifier()
                        .id(Identifiers.ProjectsPage.dropBtn)
                        .padding(leftRight = 16.px, topBottom = 10.px)
                        .borderRadius(50.px)
                        .border(2.px, LineStyle.Solid, ColorMode.current.toPalette().surfaceVariant)
                        .cursor(Cursor.Pointer)
                        .onClick {
                            toggleDropDownMenu(!showDropDownMenu)
                        },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Pick a category")

                    if (showDropDownMenu) {
                        FaChevronUp()
                    } else {
                        FaChevronDown()
                    }
                }

                Box(
                    modifier = Modifier
                        .display(if (showDropDownMenu) DisplayStyle.Flex else DisplayStyle.None)
                        .margin(top = 8.px)
                        .position(Position.Absolute)
                        .backgroundColor(ColorMode.current.toPalette().surfaceVariant)
                        .borderRadius(16.px)
                        .color(ColorMode.current.toPalette().onSurfaceVariant)
                        .boxShadow(0.px, 8.px, 16.px, 0.px, Colors.Black.copyf(alpha = 0.2f))
                        .zIndex(1)
                ) {
                    SimpleGrid(
                        numColumns = numColumns(1, 2, 3),
                        modifier = Modifier
                            .clip(RectF(16.px))
                    ) {
                        projects.flatMap { item -> item.tags }.toSet().forEach { tag ->
                            Link(
                                "",
                                modifier = ProjectTagLinkStyle.toModifier()
                                    .minWidth(175.px)
                                    .padding(topBottom = 12.px, leftRight = 16.px)
                                    .textDecorationLine(TextDecorationLine.None)
                                    .onClick {
                                        toggleFilterTag(tag)
                                    }
                            ) {
                                Checkbox(
                                    modifier = Modifier
                                        .fontSize(12.px),
                                    checked = filterTags.contains(tag.id),
                                    onCheckedChange = {
                                        toggleFilterTag(tag)
                                    }
                                ) {
                                    Text(tag.name)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

val ProjectTagLinkStyle by ComponentStyle {
    base {
        Modifier
            .transition(CSSTransition(property = "background", duration = 200.ms))
    }

    hover {
        Modifier
            .backgroundColor(colorMode.toPalette().onSurfaceVariant.toRgb().copyf(alpha = 0.2f))
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
            Modifier
                .fillMaxWidth()
                .thenIf(leftAligned.not()) {
                    Modifier.backgroundColor(ColorMode.current.toPalette().secondaryContainer)
                        .color(ColorMode.current.toPalette().onSecondaryContainer)
                },
            contentAlignment = Alignment.TopCenter
        ) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .maxWidth(Constants.SECTION_WIDTH.px),
                contentAlignment = Alignment.TopCenter
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
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
                                        .backgroundColor(if (leftAligned) ColorMode.current.toPalette().secondaryContainer else ColorMode.current.toPalette().inversePrimary)
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
                                Modifier.height(100.px)
                            })

                        ProjectImageWithLinks(breakpoint, project)
                    }
                }
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