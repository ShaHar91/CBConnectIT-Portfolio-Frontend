package com.christiano.bolla.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.christiano.bolla.models.Service
import com.christiano.bolla.models.Theme
import com.christiano.bolla.utils.Constants
import com.christiano.bolla.utils.Identifiers.ServiceCard.iconBox
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ServiceCard(service: Service) {
    val colorMode by ColorMode.currentState

    Backdrop(
        colorMode,
        modifier = Modifier
            .maxWidth(300.px)
            .margin(all = 20.px)
            .padding(all = 20.px)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .id(iconBox)
                    .margin(bottom = 20.px)
                    .border(width = (1).px, style = LineStyle.Solid, color = Theme.Primary.rgb)
                    .borderRadius(topLeft = 20.px, topRight = 20.px, bottomLeft = 20.px, bottomRight = 0.px)
            ) {
                Image(
                    modifier = Modifier.fillMaxSize()
                        .borderRadius(topLeft = 20.px, topRight = 20.px, bottomLeft = 20.px, bottomRight = 0.px),
                    src = service.icon,
                    desc = service.imageDesc
                )
            }

            P(
                attrs = Modifier
                    .fillMaxWidth()
                    .margin(top = 0.px, bottom = 10.px)
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Bold)
                    .toAttrs()
            ) {
                Text(service.title)
            }

            P(
                attrs = Modifier
                    .fillMaxWidth()
                    .margin(top = 0.px, bottom = 0.px)
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(14.px)
                    .fontWeight(FontWeight.Normal)
                    .toAttrs()
            ) {
                Text(service.description)
            }
        }
    }
}