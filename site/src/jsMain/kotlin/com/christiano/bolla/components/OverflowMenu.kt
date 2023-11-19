package com.christiano.bolla.components

import androidx.compose.runtime.*
import com.christiano.bolla.models.Section
import com.christiano.bolla.styles.NavigationItemStyle
import com.christiano.bolla.utils.Constants
import com.christiano.bolla.utils.Res
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaXmark
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.overlay.Overlay
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.*

@Composable
fun OverlowMenu(onMenuClosed: () -> Unit) {
    val scope = rememberCoroutineScope()
    val breakpoint = rememberBreakpoint()
    var translateX by remember { mutableStateOf((-100).percent) }
    var opacity by remember { mutableStateOf(0.percent) }

    fun CoroutineScope.closeMenu() {
        launch {
            translateX = (-100).percent
            opacity = 0.percent
            delay(500)
            onMenuClosed()
        }
    }

    LaunchedEffect(breakpoint) {
        delay(100) // This delay is needed for the translateX
        translateX = 0.percent
        opacity = 100.percent

        if (breakpoint > Breakpoint.MD) {
            scope.closeMenu()
        }
    }

    Overlay(modifier = Modifier
        .zIndex(2)
        .opacity(opacity)
        .transition(
            CSSTransition("opacity", 500.ms)
        )
        .onClick { scope.closeMenu() }) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.vh)
                .position(Position.Fixed)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(all = 25.px)
                    .width(if (breakpoint < Breakpoint.MD) 50.percent else 25.percent)
                    .overflow(Overflow.Auto)
                    .scrollBehavior(ScrollBehavior.Smooth)
                    .backgroundColor(ColorMode.current.toPalette().background)
                    .translateX(tx = translateX)
                    .transition(CSSTransition("translate", 500.ms))
            ) {
                Row(
                    modifier = Modifier
                        .margin(bottom = 25.px),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    FaXmark(
                        modifier = Modifier
                            .cursor(Cursor.Pointer)
                            .margin(right = 20.px, bottom = 3.px)
                            .onClick {
                                scope.closeMenu()
                            },
                        size = IconSize.LG
                    )

                    Image(
                        modifier = Modifier.size(80.px),
                        src = Res.Image.logo,
                        alt = "Logo Image"
                    )
                }

                Section.values().dropLast(2).forEach { section ->
                    Link(
                        modifier = NavigationItemStyle.toModifier()
                            .padding(bottom = 10.px)
                            .fontFamily(Constants.FONT_FAMILY)
                            .fontSize(16.px)
                            .fontWeight(FontWeight.Normal)
                            .textDecorationLine(TextDecorationLine.None)
                            .onClick {
                                scope.closeMenu()
                            },
                        path = section.path,
                        openExternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
                        text = section.title
                    )
                }
            }
        }
    }
}