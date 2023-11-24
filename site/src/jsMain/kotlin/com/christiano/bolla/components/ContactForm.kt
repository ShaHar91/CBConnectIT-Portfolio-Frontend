package com.christiano.bolla.components

import androidx.compose.runtime.Composable
import com.christiano.bolla.styles.*
import com.christiano.bolla.utils.Identifiers.AttributeName.autoComplete
import com.christiano.bolla.utils.Identifiers.AttributeName.data1PasswordIgnore
import com.christiano.bolla.utils.Identifiers.AttributeName.method
import com.christiano.bolla.utils.Identifiers.AttributeName.name
import com.christiano.bolla.utils.Identifiers.AttributeName.placeholder
import com.christiano.bolla.utils.Identifiers.AttributeName.required
import com.christiano.bolla.utils.Identifiers.ClassNames.formControl
import com.christiano.bolla.utils.Identifiers.ClassNames.formLabel
import com.christiano.bolla.utils.Identifiers.ContactForm.inputEmail
import com.christiano.bolla.utils.Identifiers.ContactForm.inputMessage
import com.christiano.bolla.utils.Identifiers.ContactForm.inputName
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
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*

@Composable
fun ContactForm(breakpoint: Breakpoint) {
    val maxWidth = when {
        breakpoint > Breakpoint.MD -> 700.px
        breakpoint == Breakpoint.MD -> 570.px
        else -> 490.px
    }

    Form(
        action = "https://formspree.io/f/maygebgo", // the navigation after this form is filled in
        attrs = Modifier
            .fillMaxWidth(80.percent)
            .maxWidth(maxWidth)
            .attrsModifier {
                attr(method, "POST")
            }.toAttrs()
    ) {
        Label(
            attrs = Modifier
                .classNames(formLabel)
                .toAttrs(),
            forId = inputName
        ) {
            Text("Name")
        }

        Input(
            type = InputType.Text,
            attrs = InputStyle.toModifier()
                .id(inputName)
                .fillMaxWidth()
                .backgroundColor(ColorMode.current.toPalette().surface)
                .color(ColorMode.current.toPalette().onSurface)
                .boxShadow(0.px, 0.px, 0.px, 0.px, null) // overrides the default behaviour of the bootstrap
                .classNames(formControl)
                .attrsModifier {
                    attr(autoComplete, "off")
                    attr(placeholder, "Full Name")
                    attr(name, "name")
                    attr(required, "true")
                    attr(data1PasswordIgnore, "") // Add this so 1Password will ignore this field
                }
                .toAttrs()
        )

        Spacer(Modifier.height(16.px))

        Label(
            attrs = Modifier
                .classNames(formLabel)
                .toAttrs(),
            forId = inputEmail
        ) {
            Text("Email")
        }

        Input(
            type = InputType.Email,
            attrs = InputStyle.toModifier()
                .id(inputEmail)
                .fillMaxWidth()
                .backgroundColor(ColorMode.current.toPalette().surface)
                .color(ColorMode.current.toPalette().onSurface)
                .boxShadow(0.px, 0.px, 0.px, 0.px, null) // overrides the default behaviour of the bootstrap
                .classNames(formControl)
                .attrsModifier {
                    attr(autoComplete, "off")
                    attr(placeholder, "Email Address")
                    attr(name, "email")
                    attr(required, "true")
                    attr(data1PasswordIgnore, "") // Add this so 1Password will ignore this field
                }
                .toAttrs()
        )

        Spacer(Modifier.height(16.px))

        Label(
            attrs = Modifier
                .classNames(formLabel)
                .toAttrs(),
            forId = inputMessage
        ) {
            Text("Message")
        }

        TextArea(
            attrs = InputStyle.toModifier()
                .id(inputMessage)
                .fillMaxWidth()
                .backgroundColor(ColorMode.current.toPalette().surface)
                .color(ColorMode.current.toPalette().onSurface)
                .classNames(formControl)
                .boxShadow(0.px, 0.px, 0.px, 0.px, null) // overrides the default behaviour of the bootstrap
                .height(150.px)
                .attrsModifier {
                    attr(placeholder, "Your Message")
                    attr(name, "message")
                    attr(required, "true")
                }
                .toAttrs()
        )

        Spacer(Modifier.height(24.px))

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
                    .cursor(Cursor.Pointer),
            ) {
                Text("Submit")
            }
        }
    }
}