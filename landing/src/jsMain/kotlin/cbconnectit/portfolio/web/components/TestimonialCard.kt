package cbconnectit.portfolio.web.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import cbconnectit.portfolio.web.data.models.domain.Testimonial
import cbconnectit.portfolio.web.styles.outlineVariant
import cbconnectit.portfolio.web.styles.primary
import cbconnectit.portfolio.web.utils.Identifiers.TestimonialSectionClasses.content
import cbconnectit.portfolio.web.utils.Identifiers.TestimonialSectionClasses.item
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
    val colorMode by ColorMode.currentState

    Box(
        Modifier
            .classNames(item)
            .fillMaxWidth()
            .borderRadius(12.px)
            .border(2.px, LineStyle.Solid, colorMode.toPalette().outlineVariant)
    ) {
        Column(
            Modifier
                .classNames(content)
                .padding(20.px)
        ) {
            Row {
                Image(
                    testimonial.imageUrl,
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
                            .color(colorMode.toPalette().primary)
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
                        Text(testimonial.jobPosition.name)
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