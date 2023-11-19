package com.christiano.bolla.components

import androidx.compose.runtime.*
import com.christiano.bolla.models.Section
import com.christiano.bolla.styles.LogoStyle
import com.christiano.bolla.styles.NavigationItemStyle
import com.christiano.bolla.styles.primary
import com.christiano.bolla.utils.Constants
import com.christiano.bolla.utils.logoImage
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.css.functions.blur
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.dom.ElementTarget
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.forms.ButtonSize
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaBars
import com.varabyte.kobweb.silk.components.icons.fa.FaMoon
import com.varabyte.kobweb.silk.components.icons.fa.FaSun
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.overlay.Tooltip
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div

@Composable
fun Header(onMenuClicked: () -> Unit) {
    val breakpoint = rememberBreakpoint()
    var scroll: Double? by remember { mutableStateOf(null) }
    var colorMode by ColorMode.currentState

    LaunchedEffect(Unit) {
        window.addEventListener(type = "scroll", callback = {
            scroll = document.documentElement?.scrollTop
        })
    }

    val backgroundColor = colorMode.toPalette().background

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.px)
            .top(0.percent) // Make it work with sticky!
            .position(Position.Sticky)
            .zIndex(1)
            .backgroundImage(
                linearGradient(
                    LinearGradient.Direction.ToBottom,
                    backgroundColor,
                    backgroundColor.toRgb().copyf(alpha = 0.5f)
                )
            )
            .backdropFilter(blur(5.px))
            .thenIf((scroll ?: 0.0) >= 50) {
                Modifier.boxShadow(0.px, 1.px, 5.px, 0.px, colorMode.toPalette().primary)
            }
            .padding(leftRight = 30.px),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LeftSide(breakpoint, colorMode, onMenuClicked)

        if (breakpoint > Breakpoint.MD) {
            RightSide()
        }

        ThemedButton(
            onClick = {
                // Toggle the color mode
                colorMode = colorMode.opposite
            },
            size = ButtonSize.SM,
            shape = ButtonShape.CIRCLE
        ) {
            when (colorMode) {
                ColorMode.DARK -> FaSun()
                ColorMode.LIGHT -> FaMoon()
            }
        }
        Tooltip(ElementTarget.PreviousSibling, "Toggle color mode")
    }
}

@Composable
fun LeftSide(
    breakpoint: Breakpoint,
    colorMode: ColorMode,
    onMenuClicked: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (breakpoint <= Breakpoint.MD) {
            FaBars(
                modifier = Modifier.onClick { onMenuClicked() },
                size = IconSize.XL
            )

            Div(attrs = Modifier.width(24.px).toAttrs())
        }

        Image(
            modifier = LogoStyle.toModifier().height(50.px),
            src = logoImage(colorMode),
            alt = "Logo Image"
        )
    }
}

@Composable
fun RightSide() {
    Row(
        modifier = Modifier
            .margin(right = 30.px)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Section.entries.take(6).forEachIndexed { index, section ->
            if (index != 0) {
                Div(attrs = Modifier.width(30.px).toAttrs())
            }

            Link(
                modifier = NavigationItemStyle.toModifier()
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(16.px)
                    .fontWeight(FontWeight.Normal)
                    .textDecorationLine(TextDecorationLine.None),
                path = section.path,
                text = section.title
            )
        }
    }
}