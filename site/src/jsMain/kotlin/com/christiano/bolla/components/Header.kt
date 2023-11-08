package com.christiano.bolla.components

import androidx.compose.runtime.*
import com.christiano.bolla.models.Section
import com.christiano.bolla.models.Theme
import com.christiano.bolla.styles.LogoStyle
import com.christiano.bolla.styles.NavigationItemStyle
import com.christiano.bolla.utils.Constants
import com.christiano.bolla.utils.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.functions.blur
import com.varabyte.kobweb.compose.css.functions.saturate
import com.varabyte.kobweb.compose.dom.ElementTarget
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
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
import com.varabyte.kobweb.silk.theme.toSilkPalette
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

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

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .top(0.percent)
            .height(60.px)
            .position(Position.Sticky)
            .zIndex(1)
            .backgroundColor(ColorMode.current.toSilkPalette().background.toRgb().copyf(alpha = 0.65f))
            .backdropFilter(saturate(180.percent), blur(5.px))
            .thenIf((scroll ?: 0.0) >= 50) {
                Modifier.boxShadow(0.px, 1.px, 5.px, 0.px, Theme.Primary.rgb)
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
                colorMode = colorMode.opposite
            },
            modifier = BUTTON_MARGIN,
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
                modifier = Modifier.margin(right = 15.px)
                    .onClick { onMenuClicked() },
                size = IconSize.XL
            )
        }

        val logo = when (colorMode) {
            ColorMode.DARK -> Res.Image.logoDark
            ColorMode.LIGHT -> Res.Image.logo
        }

        Image(
            modifier = LogoStyle.toModifier().height(50.px),
            src = logo,
            desc = "Logo Image"
        )
    }
}

@Composable
fun RightSide() {
    Row(
        modifier = Modifier
            .margin(right = 100.px)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Section.values().take(6).forEach { section ->
            Link(
                modifier = NavigationItemStyle.toModifier()
                    .padding(right = 30.px)
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Normal)
                    .textDecorationLine(TextDecorationLine.None),
                path = section.path,
                text = section.title
            )
        }
    }
}