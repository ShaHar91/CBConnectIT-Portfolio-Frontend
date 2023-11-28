package com.christiano.bolla.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.christiano.bolla.models.Service
import com.christiano.bolla.styles.primary
import com.christiano.bolla.svg.chevronRightSvg
import com.christiano.bolla.utils.Constants
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.forms.ButtonSize
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun MainServiceCard(service: Service, modifier: Modifier = Modifier, onClick: () -> Unit) {
    val colorMode by ColorMode.currentState

    Box(modifier) {
        Column(Modifier.margin(right = 24.px, bottom = 24.px)) {
            Column(Modifier.margin(left = 8.px)) {
                service.type.getServiceTypeIcon(colorMode.toPalette().primary, Modifier.size(34.px))

                Spacer(Modifier.height(10.px))

                P(
                    attrs = Modifier
                        .fillMaxWidth()
                        .margin(top = 0.px, bottom = 0.px)
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(22.px)
                        .fontWeight(FontWeight.Bold)
                        .toAttrs()
                ) {
                    Text(service.title)
                }

                Spacer(Modifier.height(10.px))

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

            Spacer(Modifier.height(10.px))

            Button(
                variant = TextPrimaryButtonVariant,
                size = ButtonSize.SM,
                onClick = { onClick() }
            ) {
                Text("Read more")

                Spacer(Modifier.width(8.px))

                chevronRightSvg(Modifier.size(18.px).margin(top = 2.px))
            }
        }
    }
}