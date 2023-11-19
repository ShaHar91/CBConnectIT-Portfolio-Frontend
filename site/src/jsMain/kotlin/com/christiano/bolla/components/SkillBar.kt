package com.christiano.bolla.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.christiano.bolla.models.lightColorScheme
import com.christiano.bolla.utils.Constants.FONT_FAMILY
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.switch
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SkillBar(
    name: String,
    index: Int,
    percentage: CSSSizeValue<CSSUnit.percent> = 50.percent,
    progressBarHeight: CSSSizeValue<CSSUnit.px> = 5.px,
    animatedPercentage: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .margin(bottom = 10.px)
            .maxWidth(500.px)
            .padding(topBottom = 5.px)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().margin(bottom = 5.px),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Normal)
                    .toAttrs()
            ) {
                Text(name)
            }

            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Normal)
                    .toAttrs()
            ) {
                Text("$animatedPercentage%")
            }
        }

        val colorMode by ColorMode.currentState

        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(progressBarHeight)
                    .backgroundColor(colorMode.toPalette().switch.backgroundOff)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth(percentage)
                    .height(progressBarHeight)
                    .backgroundColor(lightColorScheme.primary)
                    .transition(CSSTransition(property = "width", duration = 1.s, delay = 100.ms * index))
            )
        }
    }
}