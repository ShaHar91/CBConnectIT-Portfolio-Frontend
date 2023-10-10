package com.christiano.bolla.sections

import androidx.compose.runtime.*
import com.christiano.bolla.components.SectionTitle
import com.christiano.bolla.components.TestimonialCard
import com.christiano.bolla.models.Section
import com.christiano.bolla.models.Testimonial
import com.christiano.bolla.models.Theme
import com.christiano.bolla.utils.Constants
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import kotlin.math.roundToInt

@Composable
fun TestimonialSection() {
    Box(
        modifier = Modifier
            .id(Section.Testimonial.id)
            .maxWidth(Constants.SECTION_WIDTH.px)
            .padding(top = Constants.SECTION_PADDING.px),
        contentAlignment = Alignment.Center
    ) {
        TestimonialContent()
    }
}

@Composable
fun TestimonialContent() {
    val breakpoint = rememberBreakpoint()
    var selectedPage by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 100.percent else 80.percent),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier
                .fillMaxWidth()
                .margin(bottom = 25.px),
            section = Section.Testimonial,
            alignment = Alignment.CenterHorizontally
        )

        TestimonialCards(breakpoint, selectedPage)

        TestimonialNavigation(
            selectedPage = selectedPage,
            onNavigate = {
                selectedPage = it
            }
        )
    }
}

@Composable
fun TestimonialCards(
    breakpoint: Breakpoint,
    selectedPage: Int
) {
    // Create 2 lists that are holding the even and uneven indexed Testimonials
    val (testimonial1, testimonial2) = Testimonial.values().partition { it.ordinal % 2 == 0 }

    SimpleGrid(
        modifier = Modifier
            .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 90.percent else 100.percent)
            .margin(top = 20.px, bottom = 40.px),
        numColumns = numColumns(base = 1, lg = 2)
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {// Box is needed because all items will just be laid out on top of each other
            testimonial1.forEachIndexed { index, testimonial ->
                TestimonialCard(
                    modifier = Modifier
                        .margin(
                            right = if (breakpoint > Breakpoint.MD) 20.px else 0.px,
                            bottom = if (breakpoint > Breakpoint.MD) 0.px else 40.px
                        )
                        .visibility(if (index == selectedPage) Visibility.Visible else Visibility.Hidden)
                        .opacity(if (index == selectedPage) 100.percent else 0.percent)
                        .transition(
                            CSSTransition(property = "visibility", duration = 300.ms),
                            CSSTransition(property = "opacity", duration = 300.ms)
                        ),
                    testimonial
                )
            }
        }
        Box(
            contentAlignment = Alignment.Center
        ) {// Box is needed because all items will just be laid out on top of each other
            testimonial2.forEachIndexed { index, testimonial ->
                TestimonialCard(
                    modifier = Modifier
                        .margin(
                            left = if (breakpoint > Breakpoint.MD) 20.px else 0.px,
                            bottom = if (breakpoint > Breakpoint.MD) 0.px else 40.px
                        )
                        .visibility(if (index == selectedPage) Visibility.Visible else Visibility.Hidden)
                        .opacity(if (index == selectedPage) 100.percent else 0.percent)
                        .transition(
                            CSSTransition(property = "visibility", duration = 300.ms),
                            CSSTransition(property = "opacity", duration = 300.ms)
                        ),
                    testimonial
                )
            }
        }
    }
}

@Composable
fun TestimonialNavigation(
    selectedPage: Int,
    onNavigate: (Int) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        val amount = Testimonial.values().size.div(2.0).roundToInt()
        repeat(amount) { index ->
            Box(
                modifier = Modifier.margin(right = 10.px).cursor(Cursor.Pointer)
                    .size(12.px)
                    .borderRadius(50.px)
                    .backgroundColor(if (selectedPage == index) Theme.Primary.rgb else Theme.LightGray.rgb)
                    .onClick { onNavigate(index) }
            )
        }
    }
}

