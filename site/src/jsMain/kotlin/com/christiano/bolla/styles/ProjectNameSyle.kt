package com.christiano.bolla.styles

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.active
import com.varabyte.kobweb.silk.components.style.focus
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette

val ProjectNameStyle by ComponentStyle {
    hover {
        Modifier.backgroundColor(colorMode.toPalette().surface.toRgb().copy(alpha = 50))
    }

    focus {
        Modifier.backgroundColor(colorMode.toPalette().surface.toRgb().copy(alpha = 50))
    }

    active {
        Modifier.backgroundColor(colorMode.toPalette().surface.toRgb().copy(alpha = 100))
    }
}