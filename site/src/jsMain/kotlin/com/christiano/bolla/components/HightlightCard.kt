package com.christiano.bolla.components

import androidx.compose.runtime.Composable
import com.christiano.bolla.models.Theme
import com.christiano.bolla.utils.Res
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.toSilkPalette
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun HighLightCard(
    colorMode: ColorMode,
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier
) {

    Backdrop(colorMode, modifier) {
        Column(
            modifier = Modifier
                .width(100.px)
                .height(100.px)
                .color(colorMode.toSilkPalette().color),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                src = Res.Icon.experience,
                desc = "Achievement Icon"
            )

            P(
                attrs = Modifier
                    .color(Theme.Primary.rgb)
                    .margin(topBottom = 0.px)
                    .fontSize(16.px)
                    .toAttrs()
            ) {
                Text(title)
            }

            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontSize(12.px)
                    .toAttrs()
            ) {
                Text(subtitle)
            }
        }
    }

}