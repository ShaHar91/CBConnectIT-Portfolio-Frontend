package com.christiano.bolla.styles

import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.anyLink
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.theme.colors.palette.link
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*

val NavigationItemStyle by ComponentStyle {
    base {
        Modifier
            .color(colorMode.toPalette().link.default)
            .transition(CSSTransition(property = "color", duration = 200.ms))
    }

    anyLink {
        Modifier
            .color(colorMode.toPalette().link.default)
    }

    hover {
        Modifier
            .color(colorMode.toPalette().primary)
    }
}

@OptIn(ExperimentalComposeWebApi::class)
val LogoStyle by ComponentStyle {
    base {
        Modifier
            .transform { rotate(0.deg) }
            .transition(CSSTransition(property = "transform", duration = 200.ms))
    }

    hover {
        Modifier
            .transform { rotate((-10).deg) }
    }
}

val SocialLinkStyle by ComponentStyle {
    cssRule(" > #socialLink > #socialIcon") {
        Modifier
            .color(colorMode.toPalette().onSurface)
            .transition(CSSTransition(property = "color", duration = 200.ms))
    }

    cssRule(":hover > #socialLink > #socialIcon"){
        Modifier.color(colorMode.toPalette().primary)
    }
}

val MainButtonStyle by ComponentStyle {
    base {
        Modifier.width(100.px)
            .transition(CSSTransition(property = "width", duration = 200.ms))
    }

    hover {
        Modifier.width(120.px)
    }
}

@OptIn(ExperimentalComposeWebApi::class)
val MainImageStyle by ComponentStyle {
    base {
        Modifier
            .styleModifier {
                filter { grayscale(100.percent) }
            }
            .transition(CSSTransition(property = "filter", duration = 200.ms))
    }

    hover {
        Modifier
            .styleModifier {
                filter { grayscale(0.percent) }
            }
    }
}