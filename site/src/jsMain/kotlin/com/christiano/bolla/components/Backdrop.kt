package com.christiano.bolla.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.BoxScope
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundImage
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.silk.components.icons.fa.FaAndroid
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.px

@Composable
fun Backdrop(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit = {}
) {
    val colorMode by ColorMode.currentState

    val gradient = if (colorMode.isLight) {
        linearGradient(LinearGradient.Direction.ToBottomRight, Color.rgb(237,240,242), Colors.White)
    } else {
        linearGradient(LinearGradient.Direction.ToBottomRight, Color.rgb(20, 22, 28), Color.rgb(76, 79, 82))
    }

    Box(
        Modifier
            .backgroundImage(gradient)
            .borderRadius(8.px)
            .boxShadow(
                offsetY = (-0.5).px,
                offsetX = (-0.5).px,
                blurRadius = 10.px,
                color = if (colorMode.isLight) Colors.DarkGray else Colors.LightSlateGray
            )
            .then(modifier),
        content = content
    )
}