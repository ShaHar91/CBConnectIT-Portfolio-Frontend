package com.christiano.bolla.utils

import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import org.jetbrains.compose.web.css.DisplayStyle

fun Modifier.maxLines(max: Number) = this.display(DisplayStyle("-webkit-box"))
    .overflow(Overflow.Hidden)
    .attrsModifier {
        style {
            property("-webkit-line-clamp", "$max")
            property("-webkit-box-orient", "vertical")
        }
    }
