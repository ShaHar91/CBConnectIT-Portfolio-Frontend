package com.christiano.bolla.pages

import androidx.compose.runtime.*
import com.christiano.bolla.components.BackToTopButton
import com.christiano.bolla.components.OverlowMenu
import com.christiano.bolla.components.ServiceTypeCard
import com.christiano.bolla.components.Spacer
import com.christiano.bolla.models.Service
import com.christiano.bolla.models.TechnologyStacks
import com.christiano.bolla.styles.*
import com.christiano.bolla.utils.Constants
import com.christiano.bolla.utils.Res
import com.christiano.bolla.utils.markdownParagraph
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.http.http
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import kotlinx.browser.window
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Page("/services")
@Composable
fun ServicesPage() {
    var menuOpened by remember { mutableStateOf(false) }
    val breakpoint = rememberBreakpoint()
    var services by remember { mutableStateOf<List<Service>>(emptyList()) }

    LaunchedEffect(Unit) {
        val responseText = window.http.get("http://localhost:8080/api/v1/services").decodeToString()
        services = Json.decodeFromString<List<Service>>(responseText)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        PageLayout(
            Res.String.ServiceDocumentTitle,
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

                ServicesPageHeader(breakpoint, services)

                Spacer(Modifier.height(68.px))

                ServicesPageList(breakpoint, services)

                Spacer(Modifier.height(68.px))

                ServicesPageTechnologyStacks(breakpoint)

                Spacer(Modifier.height(68.px))
            }
        }

        BackToTopButton()

        if (menuOpened) {
            OverlowMenu { menuOpened = false }
        }
    }
}

@Composable
private fun ServicesPageHeader(breakpoint: Breakpoint, services: List<Service>) {
    Box(
        Modifier
            .backgroundImage(url(Res.Image.servicesBanner))
            .backgroundSize(BackgroundSize.Cover)
            .backgroundPosition(BackgroundPosition.of(CSSPosition(50.percent, 50.percent)))
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .backgroundColor(ColorMode.current.toPalette().primary.toRgb().copy(alpha = 210))
        )

        Box(
            Modifier.fillMaxWidth().maxWidth(Constants.SECTION_WIDTH.px),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                Modifier
                    .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 80.percent else 90.percent)
                    .margin(topBottom = if (breakpoint >= Breakpoint.MD) 108.px else 56.px)
            ) {
                P(
                    Modifier
                        .color(ColorMode.current.toPalette().onPrimary)
                        .maxWidth(if (breakpoint > Breakpoint.MD) 65.percent else 100.percent)
                        .margin(topBottom = 0.px)
                        .fontSize(32.px)
                        .fontWeight(FontWeight.Bold)
                        .toAttrs()
                ) {
                    Text(
                        Res.String.MyServices
                    )
                }

                Spacer(Modifier.height(12.px))

                P(
                    Modifier
                        .color(ColorMode.current.toPalette().onPrimary)
                        .maxWidth(if (breakpoint > Breakpoint.MD) 65.percent else 100.percent)
                        .margin(topBottom = 0.px)
                        .fontSize(22.px)
                        .toAttrs {
                            markdownParagraph(Res.String.ServicesBannerDescription)
                        }
                )

                if (breakpoint <= Breakpoint.MD) {
                    Spacer(Modifier.height(68.px))

                    services.forEachIndexed { index, service ->
                        if (index != 0) {
                            Spacer(Modifier.height(50.px))
                        }

                        ServiceTypeCard(service)
                    }
                }
            }
        }
    }

    if (breakpoint > Breakpoint.MD) {
        Box(
            Modifier.fillMaxWidth().maxWidth(Constants.SECTION_WIDTH.px),
            contentAlignment = Alignment.TopCenter
        ) {
            Row(
                Modifier
                    .margin(leftRight = 144.px)
                    .margin(top = (-50).px)
                    .fillMaxWidth(80.percent)
                    .maxWidth(Constants.SECTION_WIDTH.px)
            ) {
                services.forEachIndexed { index, service ->
                    if (index != 0) {
                        Spacer(Modifier.width(100.px))
                    }

                    ServiceTypeCard(service)
                }
            }
        }
    }
}

@Composable
private fun ServicesPageList(breakpoint: Breakpoint, services: List<Service>) {
    val pageContext = rememberPageContext()

    services.forEachIndexed { index, service ->
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
                    Modifier
                        .fillMaxWidth()
                        .id(service.id)
                        .scrollMargin(top = 60.px)
                        .display(DisplayStyle.Flex)
                        .flexDirection(if (breakpoint > Breakpoint.MD) FlexDirection.Row else FlexDirection.Column)
                        .alignItems(AlignItems.Center)
                        .padding(topBottom = 50.px, leftRight = 10.percent)
                ) {
                    if (leftAligned && breakpoint > Breakpoint.MD) {
                        Image(service.typeImage, Modifier.width(350.px))

                        Spacer(Modifier.width(100.px))
                    }

                    Column(Modifier.fillMaxWidth()) {
                        P(
                            attrs = Modifier
                                .fontSize(32.px)
                                .fontWeight(FontWeight.Bold)
                                .fontFamily(Constants.FONT_FAMILY)
                                .toAttrs()
                        ) {
                            Text(service.title)
                        }

                        Spacer(Modifier.height(24.px))

                        P(
                            attrs = Modifier
                                .fontSize(22.px)
                                .fontFamily(Constants.FONT_FAMILY)
                                .toAttrs {
                                    markdownParagraph(service.shortDescription ?: "")
                                }
                        )

                        Spacer(Modifier.height(24.px))

                        Button(
                            modifier = MainButtonStyle.toModifier(),
                            onClick = {
                                pageContext.router.navigateTo("/services/${service.id}")
                            }
                        ) {
                            Text(Res.String.LearnMore)
                        }
                    }


                    if (leftAligned.not() || breakpoint <= Breakpoint.MD) {
                        Spacer(Modifier
                            .width(100.px)
                            .thenIf(breakpoint <= Breakpoint.MD) {
                                Modifier.height(40.px)
                            })

                        Image(
                            service.typeImage,
                            Modifier.maxWidth(350.px)
                                .thenIf(breakpoint <= Breakpoint.MD) {
                                    Modifier.fillMaxWidth(90.percent)
                                }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ServicesPageTechnologyStacks(breakpoint: Breakpoint) {
    Box(
        Modifier
            .fillMaxWidth()
            .maxWidth(Constants.SECTION_WIDTH.px),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 70.percent else 90.percent
            ),
        ) {
            P(
                attrs =
                Modifier
                    .fillMaxWidth()
                    .textAlign(TextAlign.Center)
                    .fontWeight(FontWeight.Bold)
                    .fontSize(if (breakpoint < Breakpoint.MD) 32.px else 45.px)
                    .toAttrs()
            ) {
                Text(Res.String.TechnologyStacks)
            }

            Spacer(Modifier.height(40.px))

            Box(
                Modifier
                    .display(DisplayStyle.Flex)
                    .flexDirection(FlexDirection.Row)
                    .flexWrap(FlexWrap.Wrap)
                    .justifyContent(JustifyContent.Center)
                    .gap(60.px)
            ) {
                TechnologyStacks.entries.forEach {
                    Image(it.icon, modifier = Modifier.size(if (breakpoint < Breakpoint.MD) 58.px else 114.px))
                }
            }
        }
    }
}