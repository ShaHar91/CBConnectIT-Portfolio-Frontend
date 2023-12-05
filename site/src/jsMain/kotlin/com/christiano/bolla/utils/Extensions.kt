package com.christiano.bolla.utils

import com.christiano.bolla.externals.parse
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.css.DisplayStyle
import org.w3c.dom.HTMLParagraphElement

fun Modifier.maxLines(max: Number) = this.display(DisplayStyle("-webkit-box"))
    .overflow(Overflow.Hidden)
    .attrsModifier {
        style {
            property("-webkit-line-clamp", "$max")
            property("-webkit-box-orient", "vertical")
        }
    }

fun AttrsScope<HTMLParagraphElement>.markdownParagraph(
    text: String,
    breaks: Boolean = false,
    vararg classes: String,
) {
    if (classes.isNotEmpty()) classes(*classes)

    val textToParse = if (breaks) text.replace("\n", "<br>") else text

    this.prop({ htmlParagraphElement: HTMLParagraphElement, s: String -> htmlParagraphElement.innerHTML = s }, parse(textToParse))
}