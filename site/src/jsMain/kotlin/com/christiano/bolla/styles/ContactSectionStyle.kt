package com.christiano.bolla.styles

import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.focus
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val InputStyle by ComponentStyle {
    base {
        Modifier
            .border(width = 2.px, style = LineStyle.Solid, color = colorMode.toPalette().surface)
            .transition(CSSTransition(property = "border", duration = 200.ms))
    }

    focus {
        Modifier.border(width = 2.px, style = LineStyle.Solid, color = colorMode.toPalette().primary)
    }

    hover {
        Modifier.border(width = 2.px, style = LineStyle.Solid, color = colorMode.toPalette().primary)
    }
}