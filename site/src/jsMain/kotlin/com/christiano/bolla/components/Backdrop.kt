package com.christiano.bolla.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.BoxScope
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundImage
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.silk.components.icons.fa.FaAndroid
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.px

@Composable
fun Backdrop(
    colorMode: ColorMode,
    modifier: Modifier = Modifier,
    borderRadius: CSSSizeValue<CSSUnit.px> = 8.px,
    content: @Composable BoxScope.() -> Unit = {}
) {
    val gradient = if (colorMode.isLight) {
        linearGradient(LinearGradient.Direction.ToBottomRight, Color.rgb(237,240,242), Colors.White)
    } else {
        linearGradient(LinearGradient.Direction.ToBottomRight, Color.rgb(20, 22, 28), Color.rgb(76, 79, 82))
    }

    Box(
        Modifier
            .backgroundImage(gradient)
            .borderRadius(borderRadius)
            .boxShadow(
                offsetY = (-0.5).px,
                offsetX = (-0.5).px,
                blurRadius = 10.px,
                color = if (colorMode.isLight) Colors.DarkGray.copy(alpha = 100) else Colors.White.copy(alpha = 100)
            )
            .then(modifier),
        contentAlignment = Alignment.Center,
        content = content
    )
}