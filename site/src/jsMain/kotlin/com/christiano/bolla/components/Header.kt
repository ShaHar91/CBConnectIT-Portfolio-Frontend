package com.christiano.bolla.components

import androidx.compose.runtime.Composable
import com.christiano.bolla.models.Section
import com.christiano.bolla.models.Theme
import com.christiano.bolla.styles.LogoStyle
import com.christiano.bolla.styles.NavigationItemStyle
import com.christiano.bolla.utils.Constants
import com.christiano.bolla.utils.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaBars
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun Header(onMenuClicked: () -> Unit) {
    val breakpoint = rememberBreakpoint()

    Row(
        modifier = Modifier
            .fillMaxWidth(if (breakpoint > Breakpoint.MD) 80.percent else 90.percent)
            .margin(topBottom = 50.px),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LeftSide(breakpoint, onMenuClicked)

        if (breakpoint > Breakpoint.MD) {
            RightSide()
        }
    }
}

@Composable
fun LeftSide(breakpoint: Breakpoint,
             onMenuClicked: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (breakpoint <= Breakpoint.MD) {
            FaBars(
                modifier = Modifier.margin(right = 15.px)
                    .onClick {onMenuClicked() },
                size = IconSize.XL
            )
        }

        Image(
            modifier = LogoStyle.toModifier(),
            src = Res.Image.logo,
            desc = "Logo Image"
        )
    }
}

@androidx.compose.runtime.Composable
fun RightSide() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .borderRadius(r = 50.px)
            .backgroundColor(Theme.LighterGray.rgb)
            .padding(all = 20.px),
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