package com.christiano.bolla.pages

import androidx.compose.runtime.*
import com.christiano.bolla.components.BackToTopButton
import com.christiano.bolla.components.OverlowMenu
import com.christiano.bolla.components.Spacer
import com.christiano.bolla.models.Service
import com.christiano.bolla.styles.*
import com.christiano.bolla.utils.Constants
import com.christiano.bolla.utils.Res
import com.christiano.bolla.utils.markdownParagraph
import com.varabyte.kobweb.compose.css.BackgroundSize
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

@Page("/services/{serviceId}")
@Composable
fun ServicePage() {
    var menuOpened by remember { mutableStateOf(false) }
    val breakpoint = rememberBreakpoint()
    val ctx = rememberPageContext()
    val serviceId = ctx.route.params.getValue("serviceId")

    var service by remember { mutableStateOf<Service?>(null) }

    LaunchedEffect(Unit) {
        val responseText = window.http.get("/api/services.json").decodeToString()
        val response = Json.decodeFromString<List<Service>>(responseText)
        println("serviceId: $serviceId, serviceName: $response")
        println("${response.find { it.id == serviceId }}")
        service = response.find { it.id == serviceId }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        PageLayout(
            "Services: ${service?.title}",
            false,
            {
                menuOpened = true
            }) {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    Modifier
                        .backgroundImage(url(service?.image ?: Res.Image.servicesBanner))
                        .backgroundSize(BackgroundSize.Cover)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        Modifier
                            .fillMaxSize()
                            .backgroundColor(ColorMode.current.toPalette().primary.toRgb().copy(alpha = 210))
                    )

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

                        if (service != null) {
                            P(
                                Modifier
                                    .color(ColorMode.current.toPalette().onPrimary)
                                    .maxWidth(if (breakpoint > Breakpoint.MD) 65.percent else 85.percent)
                                    .margin(topBottom = 0.px)
                                    .fontSize(22.px)
                                    .toAttrs {
                                        markdownParagraph(service!!.bannerDescription)
                                    }
                            )
                        }
                    }
                }

                Spacer(Modifier.height(68.px))

                service?.subServices?.forEachIndexed { index, subService ->
                    val leftAligned = index % 2 == 0

                    if (index != 0) {
                        Spacer(Modifier.height(68.px))
                    }

                    Box(
                        Modifier
                            .fillMaxWidth()
                            .scrollMargin(top = 60.px)
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
                            Image(subService.image ?: "", Modifier.width(350.px))

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
                                    .fontSize(22.px)
                                    .fontFamily(Constants.FONT_FAMILY)
                                    .toAttrs {
                                        markdownParagraph(subService.description)
                                    }
                            )

                            Spacer(Modifier.height(24.px))

                            Button(
                                modifier = MainButtonStyle.toModifier(),
                                onClick = {
                                    //TODO: navigate to projects list!
                                }
                            ) {
                                Text("Learn more")
                            }
                        }


                        if (leftAligned.not() || breakpoint <= Breakpoint.MD) {
                            Spacer(Modifier
                                .width(100.px)
                                .thenIf(breakpoint <= Breakpoint.MD) {
                                    Modifier.height(40.px)
                                })

                            Image(
                                subService.image ?: "",
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