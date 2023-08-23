package com.christiano.bolla.styles

import com.christiano.bolla.models.Theme
import com.christiano.bolla.utils.Identifiers.ServiceCard.iconBox
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val ServiceCardStyle by ComponentStyle {
    base {
        Modifier
            .border(width = 2.px, style = LineStyle.Solid, color = Theme.LighterGray.rgb)
            .backgroundColor(Colors.White)
            .transition(
                CSSTransition("border", 200.ms),
                CSSTransition("background", 200.ms)
                )
    }

    hover {
        Modifier
            .border(width = 2.px, style = LineStyle.Solid, color = Theme.Primary.rgb)
            .backgroundColor(Theme.Primary.rgb)
    }

    // This means we are targeting a child element with the id `iconBox`
    cssRule(" > #$iconBox") {
        Modifier.backgroundColor(Colors.Transparent)
            .transition(CSSTransition("background", 200.ms))

    }

    cssRule(":hover > #$iconBox") {
        Modifier.backgroundColor(Colors.White)
    }

    // This means we are targeting all child elements of type 'P'
    cssRule(" > p") {
        Modifier
//            .color(Theme.Secondary.rgb)
            .transition(CSSTransition("color", 200.ms))

    }

    cssRule(":hover > p") {
        Modifier.color(Colors.White)
    }
}