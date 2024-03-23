package com.christiano.bolla.pages

import androidx.compose.runtime.*
import com.christiano.bolla.components.BackToTopButton
import com.christiano.bolla.components.OverlowMenu
import com.christiano.bolla.components.Spacer
import com.christiano.bolla.models.Service
import com.christiano.bolla.styles.*
import com.christiano.bolla.utils.*
import com.varabyte.kobweb.compose.css.BackgroundPosition
import com.varabyte.kobweb.compose.css.BackgroundSize
import com.varabyte.kobweb.compose.css.CSSPosition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.functions.url
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
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Page("/services/{${Identifiers.PathParams.ServiceId}}")
@Composable
fun ServicePage() {
    var menuOpened by remember { mutableStateOf(false) }
    val breakpoint = rememberBreakpoint()
    val ctx = rememberPageContext()
    val serviceId = ctx.route.params.getValue(Identifiers.PathParams.ServiceId)

    var service by remember { mutableStateOf<Service?>(null) }

    LaunchedEffect(Unit) {
        val responseText = window.http.get("http://localhost:8080/api/v1/services/$serviceId").decodeToString()
        service = Json.decodeFromString<Service>(responseText)
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        PageLayout(
            Res.String.SubServicesDocumentTitle.format(service?.title),
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
                ServiceBanner(service, breakpoint)

                val subServices = service?.subServices
                if (subServices.isNullOrEmpty().not()) {
                    Spacer(Modifier.height(68.px))

                    SubServices(subServices!!, breakpoint)
                }

                val extraInfo = service?.extraInfo
                if (extraInfo.isNullOrEmpty().not()) {
                    Spacer(Modifier.height(68.px))

                    Box(
                        Modifier
                            .fillMaxWidth()
                            .maxWidth(Constants.SECTION_WIDTH.px),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        P(
                            attrs = Modifier
                                .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 80.percent else 90.percent)
                                .fontSize(22.px)
                                .fontFamily(Constants.FONT_FAMILY)
                                .toAttrs {
                                    markdownParagraph(extraInfo!!)
                                }

                        )
                    }
                }
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
fun ServiceBanner(service: Service?, breakpoint: Breakpoint) {
    Box(
        Modifier
            .backgroundImage(url(service?.imageUrl ?: Res.Image.servicesBanner))
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
            Modifier
                .fillMaxWidth()
                .maxWidth(Constants.SECTION_WIDTH.px),
            contentAlignment = Alignment.TopCenter
        ) {

            Column(
                Modifier
                    .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 80.percent else 90.percent)
                    .margin(topBottom = if (breakpoint >= Breakpoint.MD) 108.px else 56.px),
            ) {
                P(
                    Modifier
                        .color(ColorMode.current.toPalette().onPrimary)
                        .maxWidth(if (breakpoint > Breakpoint.MD) 65.percent else 85.percent)
                        .margin(topBottom = 0.px)
                        .fontSize(32.px)
                        .fontWeight(FontWeight.Bold)
                        .toAttrs()
                ) {
                    Text(
                        service?.title ?: ""
                    )
                }

                Spacer(Modifier.height(12.px))

                if (service?.bannerDescription != null) {
                    P(
                        Modifier
                            .color(ColorMode.current.toPalette().onPrimary)
                            .maxWidth(if (breakpoint > Breakpoint.MD) 65.percent else 85.percent)
                            .margin(topBottom = 0.px)
                            .fontSize(22.px)
                            .toAttrs {
                                markdownParagraph(service.bannerDescription)
                            }
                    )
                }
            }
        }
    }
}

@Composable
fun SubServices(subServices: List<Service>, breakpoint: Breakpoint) {
    val ctx = rememberPageContext()

    subServices.forEachIndexed { index, subService ->
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
                        .scrollMargin(top = 60.px)
                        .display(DisplayStyle.Flex)
                        .flexDirection(if (breakpoint > Breakpoint.MD) FlexDirection.Row else FlexDirection.Column)
                        .alignItems(AlignItems.Center)
                        .padding(topBottom = 50.px, leftRight = 10.percent)
                ) {
                    if (leftAligned && breakpoint > Breakpoint.MD) {
                        Image(subService.imageUrl, Modifier.width(275.px))

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
                            Text(subService.title)
                        }

                        Spacer(Modifier.height(24.px))

                        P(
                            attrs = Modifier
                                .fontSize(18.px)
                                .fontFamily(Constants.FONT_FAMILY)
                                .toAttrs {
                                    markdownParagraph(subService.description)
                                }
                        )

                        Spacer(Modifier.height(24.px))

                        Button(
                            modifier = MainButtonStyle.toModifier(),
                            onClick = {
                                // Keeping it like this for the possible support of multiple tags per sub-service
                                val tagsQuery = listOf(subService.tag).joinToStringIndexed("&") { index, tag -> "${Identifiers.PathParams.Tag}$index=${tag?.id}" }
                                ctx.router.navigateTo("/projects?$tagsQuery")
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
                            subService.imageUrl,
                            Modifier.maxWidth(250.px)
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