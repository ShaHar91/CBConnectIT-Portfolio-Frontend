package com.christiano.bolla.sections

import androidx.compose.runtime.*
import com.christiano.bolla.components.SectionTitle
import com.christiano.bolla.components.Spacer
import com.christiano.bolla.components.TestimonialCard
import com.christiano.bolla.models.Section
import com.christiano.bolla.models.Testimonial
import com.christiano.bolla.utils.Constants
import com.christiano.bolla.utils.Identifiers.AttributeName.style
import com.christiano.bolla.utils.Identifiers.PropertyName.gridAutoRows
import com.christiano.bolla.utils.Identifiers.PropertyName.gridRowEnd
import com.christiano.bolla.utils.Identifiers.PropertyName.gridRowGap
import com.christiano.bolla.utils.Identifiers.TestimonialSectionClasses.content
import com.christiano.bolla.utils.Identifiers.TestimonialSectionClasses.grid
import com.christiano.bolla.utils.Identifiers.TestimonialSectionClasses.item
import com.varabyte.kobweb.compose.css.GridEntry
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.http.http
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.Element
import org.w3c.dom.asList
import org.w3c.dom.get
import kotlin.math.ceil

@Composable
fun TestimonialSection() {
    Box(
        modifier = Modifier
            .id(Section.Testimonial.id)
            .scrollMargin(60.px)
            .fillMaxWidth()
            .maxWidth(Constants.SECTION_WIDTH.px),
        contentAlignment = Alignment.Center
    ) {
        TestimonialContent()
    }
}

private fun recalculateGridItems() {
    CoroutineScope(Dispatchers.Default).launch {
        delay(100)
        resizeAllGridItems()
    }
}

@Composable
fun TestimonialContent() {
    val breakpoint = rememberBreakpoint()
    var testimonials by remember { mutableStateOf(emptyList<Testimonial>()) }

    LaunchedEffect(Unit) {
        val responseText = window.http.get("http://localhost:8080/api/v1/testimonials").decodeToString()

        testimonials = Json.decodeFromString(responseText)

        delay(250)
        resizeAllGridItems()
    }

    window.addEventListener("resize", {
        recalculateGridItems()
    })
    // A custom event listener, so we can listen to this change in order to recalculate grid item size for the testimonials
    window.addEventListener("update-color-mode", {
        recalculateGridItems()
    })

    Column(
        modifier = Modifier
            .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 80.percent else 90.percent),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier
                .fillMaxWidth(),
            section = Section.Testimonial,
            alignment = Alignment.CenterHorizontally,
            href = null // TODO: add navigation
//            showSeeAllButton = true
        )

        val widthPercentage = when {
            breakpoint > Breakpoint.MD -> 30.percent
            breakpoint == Breakpoint.MD -> 48.percent
            else -> 100.percent
        }

        Spacer(Modifier.height(25.px))

        Div(
            Modifier
                .classNames(grid)
                .fillMaxWidth()
                .display(DisplayStyle.Grid)
                .gridTemplateColumns {
                    repeat(GridEntry.Repeat.Auto.Type.AutoFill) {
                        minmax(widthPercentage, 1.fr)
                    }
                }
                .gap(24.px)
                .gridAutoRows {
                    size(12.px)
                }
                .toAttrs()
        ) {
            testimonials.forEach {
                TestimonialCard(testimonial = it)
            }
        }
    }
}

/**
 * Resize the grid items to use the specific height. Inspiration taken from
 *
 * https://codepen.io/andybarefoot/pen/QMeZda
 * https://medium.com/@andybarefoot/a-masonry-style-layout-using-css-grid-8c663d355ebb
 */
private fun resizeAllGridItems() {
    val allItems = document.getElementsByClassName(item)
    allItems.asList().forEach {
        resizeGridItem(it)
    }
}

private fun resizeGridItem(element: Element) {
    val grid = document.getElementsByClassName(grid)[0]
    if (grid != null) {
        val rowHeight = window.getComputedStyle(grid).getPropertyValue(gridAutoRows).substringBefore("px")
        val rowGap = window.getComputedStyle(grid).getPropertyValue(gridRowGap).substringBefore("px").toDoubleOrNull() ?: 0.0
        val some = element.querySelector(".$content")?.getBoundingClientRect()?.height?.plus(rowGap)
        val other = rowHeight.toDouble().plus(rowGap)
        val rowSpan = ceil(some?.div(other) ?: 0.0)

        val attributes = element.getAttribute(style)
        if (attributes != null) {
            val realEnding = if (attributes.contains(gridRowEnd)) {
                val index = attributes.indexOf(gridRowEnd)
                attributes.removeRange(index, attributes.length)
            } else attributes

            element.setAttribute(style, "$realEnding$gridRowEnd: span $rowSpan;")
        }
    }
}
