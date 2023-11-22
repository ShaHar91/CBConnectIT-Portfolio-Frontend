package com.christiano.bolla.components

import androidx.compose.runtime.Composable
import com.christiano.bolla.models.Testimonial
import com.christiano.bolla.styles.outlineVariant
import com.christiano.bolla.styles.primary
import com.christiano.bolla.utils.Identifiers.TestimonialSectionClasses.content
import com.christiano.bolla.utils.Identifiers.TestimonialSectionClasses.item
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun TestimonialCard(
    testimonial: Testimonial
) {
    Box(
        Modifier
            .classNames(item)
            .fillMaxWidth()
            .borderRadius(12.px)
            .border(2.px, LineStyle.Solid, ColorMode.current.toPalette().outlineVariant)
    ) {
        Column(
            Modifier
                .classNames(content)
                .padding(20.px)
        ) {
            Row {
                Image(
                    testimonial.image,
                    modifier = Modifier
                        .weight(1)
                        .size(56.px)
                        .borderRadius(50.percent),
                    alt = "Testimonial avatar image"
                )

                Spacer(Modifier.width(12.px))

                Column {
                    P(
                        Modifier
                            .fillMaxWidth()
                            .margin(0.px, 0.px)
                            .color(ColorMode.current.toPalette().primary)
                            .fontSize(22.px)
                            .fontWeight(FontWeight.Bold)
                            .toAttrs()
                    ) {
                        Text(testimonial.fullName)
                    }

                    Spacer(Modifier.height(4.px))

                    P(
                        Modifier
                            .fillMaxWidth()
                            .margin(0.px, 0.px)
                            .fontSize(14.px)
                            .fontWeight(FontWeight.Medium)
                            .toAttrs()
                    ) {
                        Text(testimonial.function)
                    }
                }
            }

            Spacer(Modifier.height(16.px))

            P(
                Modifier
                    .fillMaxWidth()
                    .margin(0.px, 0.px)
                    .fontSize(14.px)
                    .toAttrs()
            ) {
                Text(testimonial.review)
            }
        }
    }
}