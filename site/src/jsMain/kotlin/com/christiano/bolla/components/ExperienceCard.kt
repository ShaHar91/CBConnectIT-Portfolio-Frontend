package com.christiano.bolla.components

import androidx.compose.runtime.Composable
import com.christiano.bolla.models.Experience
import com.christiano.bolla.models.lightColorScheme
import com.christiano.bolla.utils.Constants
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.color
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ExperienceCard(
    breakpoint: Breakpoint,
    active: Boolean = false,
    experience: Experience,
    animatedMargin: CSSSizeValue<CSSUnit.px>
) {
    SimpleGrid(
        modifier = Modifier
            .fillMaxWidth(if (breakpoint > Breakpoint.MD) 60.percent else 100.percent),
        numColumns = numColumns(base = 1, lg = 2)
    ) {
        ExperienceDescription(active, experience.description)
        ExperienceDetails(breakpoint, active, experience, animatedMargin)
    }
}

@Composable
fun ExperienceDescription(
    active: Boolean,
    description: String
) {
    Box(
        modifier = Modifier.fillMaxWidth()
            .margin(topBottom = 14.px)
            .padding(all = 14.px)
            .thenIf(active && ColorMode.current.isLight) {
                Modifier.color(ColorMode.current.opposite.toPalette().color)
            }
            .backgroundColor(if (active) lightColorScheme.primary else ColorMode.current.toPalette().background.darkened(0.1f))
    ) {
        P(
            attrs = Modifier
                .margin(topBottom = 0.px)
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(14.px)
                .whiteSpace(WhiteSpace.PreLine)
                .fontWeight(FontWeight.Normal)
                .lineHeight(1.85)
                .toAttrs()
        ) {
            Text(description)
        }
    }
}

@Composable
fun ExperienceDetails(
    breakpoint: Breakpoint,
    active: Boolean,
    experience: Experience,
    animatedMargin: CSSSizeValue<CSSUnit.px>
) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .margin(left = if (breakpoint > Breakpoint.MD) 14.px else 0.px),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (breakpoint > Breakpoint.MD) {
            ExperiencNumber(active, experience)
        }

        Column(
            modifier = Modifier.fillMaxSize()
                .margin(left = animatedMargin)
                .transition(CSSTransition(property = "margin", duration = 500.ms, delay = experience.ordinal * 100.ms)),
            verticalArrangement = Arrangement.Center
        ) {
            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(20.px)
                    .fontWeight(FontWeight.Bold)
                    .toAttrs()
            ) {
                Text(experience.jobPosition)
            }

            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(14.px)
                    .fontWeight(FontWeight.Normal)
                    .toAttrs()
            ) {
                Text("${experience.from} - ${experience.to}")
            }

            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(14.px)
                    .fontWeight(FontWeight.Normal)
                    .toAttrs()
            ) {
                Text(experience.company)
            }
        }
    }
}

@Composable
fun ExperiencNumber(
    active: Boolean,
    experience: Experience
) {
    Box(
        modifier = Modifier.fillMaxHeight()
            .margin(right = 14.px),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier.fillMaxHeight()
                .width(3.px)
                .backgroundColor(lightColorScheme.primary)
        )

        Box(
            modifier = Modifier.size(40.px)
                .border(width = 3.px, style = LineStyle.Solid, lightColorScheme.primary)
                .backgroundColor(if (active) lightColorScheme.primary else ColorMode.current.toPalette().background)
                .borderRadius(50.percent),
            contentAlignment = Alignment.Center
        ) {
            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(16.px)
                    .fontWeight(FontWeight.Bold)
                    .color(if (active) Colors.White else lightColorScheme.primary)
                    .toAttrs()
            ) {
                Text(experience.number)
            }
        }
    }
}