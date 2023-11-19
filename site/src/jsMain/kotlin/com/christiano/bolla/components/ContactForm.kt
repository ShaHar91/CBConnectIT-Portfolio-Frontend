package com.christiano.bolla.components

import androidx.compose.runtime.Composable
import com.christiano.bolla.models.lightColorScheme
import com.christiano.bolla.styles.InputStyle
import com.christiano.bolla.styles.MainButtonStyle
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.color
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*

@Composable
fun ContactForm(breakpoint: Breakpoint) {
    Form(
        action = "https://formspree.io/f/maygebgo", // the navigation after this form is filled in
        attrs = Modifier.attrsModifier {
            attr("method", "POST")
        }.toAttrs()
    ) {
        Label(
            attrs = Modifier
                .classNames("form-label")
                .toAttrs(),
            forId = "inputName"
        ) {
            Text("Name")
        }

        Input(
            type = InputType.Text,
            attrs = InputStyle.toModifier()
                .id("inputName")
                .width(if (breakpoint >= Breakpoint.MD) 500.px else 250.px)
                .margin(bottom = 10.px)
                .backgroundColor(lightColorScheme.surface)
                .boxShadow(0.px, 0.px, 0.px, 0.px, null) // overrides the default behaviour of the bootstrap
                .classNames("form-control")
                .attrsModifier {
                    attr("autocomplete", "off")
                    attr("placeholder", "Full Name")
                    attr("name", "name")
                    attr("required", "true")
                    attr("data-1p-ignore", "") // Add this so 1Password will ignore this field
                }
                .toAttrs()
        )

        Label(
            attrs = Modifier
                .classNames("form-label")
                .toAttrs(),
            forId = "inputEmail"
        ) {
            Text("Email")
        }

        Input(
            type = InputType.Email,
            attrs = InputStyle.toModifier()
                .id("inputEmail")
                .width(if (breakpoint >= Breakpoint.MD) 500.px else 250.px)
                .backgroundColor(lightColorScheme.surface)
                .boxShadow(0.px, 0.px, 0.px, 0.px, null) // overrides the default behaviour of the bootstrap
                .margin(bottom = 10.px)
                .classNames("form-control")
                .attrsModifier {
                    attr("autocomplete", "off")
                    attr("placeholder", "Email Address")
                    attr("name", "email")
                    attr("required", "true")
                    attr("data-1p-ignore", "") // Add this so 1Password will ignore this field
                }
                .toAttrs()
        )

        Label(
            attrs = Modifier
                .classNames("form-label")
                .toAttrs(),
            forId = "inputMessage"
        ) {
            Text("Message")
        }

        TextArea(
            attrs = InputStyle.toModifier()
                .id("inputMessage")
                .margin(bottom = 20.px)
                .width(if (breakpoint >= Breakpoint.MD) 500.px else 250.px)
                .backgroundColor(lightColorScheme.surface)
                .classNames("form-control")
                .boxShadow(0.px, 0.px, 0.px, 0.px, null) // overrides the default behaviour of the bootstrap
                .height(150.px)
                .attrsModifier {
                    attr("placeholder", "Your Message")
                    attr("name", "message")
                    attr("required", "true")
                }
                .toAttrs()
        )

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            com.varabyte.kobweb.silk.components.forms.Button(
                type = ButtonType.Submit,
                onClick = {},
                modifier = MainButtonStyle.toModifier()
                    .height(40.px)
                    .border(width = 0.px)
                    .borderRadius(r = 5.px)
                    .cursor(Cursor.Pointer)
                    .color(ColorMode.current.opposite.toPalette().color), // The color is being used for the Text color!
            ) {
                Text("Submit")
            }
        }
    }
}