package com.christiano.bolla

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import com.christiano.bolla.models.Theme
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.silk.SilkApp
import com.varabyte.kobweb.silk.components.layout.Surface
import com.varabyte.kobweb.silk.components.style.common.SmoothColorStyle
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.MutableSilkPalette
import com.varabyte.kobweb.silk.theme.colors.getColorMode
import com.varabyte.kobweb.silk.theme.toSilkPalette
import kotlinx.browser.localStorage
import org.jetbrains.compose.web.css.vh

private const val COLOR_MODE_KEY = "app:colorMode"

@InitSilk
fun updateTheme(ctx: InitSilkContext) {
    ctx.config.initialColorMode = localStorage.getItem(COLOR_MODE_KEY)?.let { ColorMode.valueOf(it) } ?: ColorMode.DARK

    ctx.theme.palettes.light.background = Color.rgb(237, 240, 243)
    ctx.theme.palettes.dark.background = Color.rgb(34, 36, 41)

    ctx.theme.palettes.light.color = Colors.Black
    ctx.theme.palettes.dark.color = Colors.White

    ctx.theme.palettes.light.button = MutableSilkPalette.Button(
        default = Theme.Primary.silkRgb,
        hover = Theme.Primary.silkRgb,
        focus = Theme.Primary.silkRgb,
        pressed = Theme.Secondary.silkRgb
    )

    ctx.theme.palettes.dark.button = MutableSilkPalette.Button(
        default = Theme.Secondary.silkRgb,
        hover = Theme.Secondary.silkRgb,
        focus = Theme.Secondary.silkRgb,
        pressed = Theme.Primary.silkRgb
    )


//    ctx.theme.palettes = MutableSilkPalettes(
//        light = MutableSilkPalette(
//            background = Theme.Secondary.silkRgb,
//            color = Colors.Black,
//            link = MutableSilkPalette.Link(
//                default = Colors.Black,
//                visited = Colors.Black
//            ),
//            button = MutableSilkPalette.Button(
//                default = Theme.Primary.silkRgb,
//                hover = Theme.Primary.silkRgb,
//                focus = Theme.Primary.silkRgb,
//                pressed = Theme.Secondary.silkRgb
//            ),
//            switch = MutableSilkPalette.Switch(
//                backgroundOn = Colors.DarkGray,
//                backgroundOff = Colors.LightGray,
//                thumb = Theme.Primary.silkRgb
//            ),
//            tab = MutableSilkPalette.Tab(
//                color = Colors.White,
//                background = Colors.White,
//                selectedColor = Colors.White,
//                hover = Colors.White,
//                pressed = Colors.White,
//                disabled = Colors.White
//            )
//        ),
//        dark = MutableSilkPalette(
//            background = Theme.Primary.silkRgb,
//            color = Colors.White,
//            link = MutableSilkPalette.Link(
//                default = Colors.White,
//                visited = Colors.White
//            ),
//            button = MutableSilkPalette.Button(
//                default = Theme.Secondary.silkRgb,
//                hover = Theme.Secondary.silkRgb,
//                focus = Theme.Secondary.silkRgb,
//                pressed = Theme.Primary.silkRgb
//            ),
//            switch = MutableSilkPalette.Switch(
//                backgroundOn = Colors.Blue,
//                backgroundOff = Colors.MediumBlue,
//                thumb = Theme.Primary.silkRgb
//            ),
//            tab = MutableSilkPalette.Tab(
//                color = Colors.White,
//                background = Colors.White,
//                selectedColor = Colors.White,
//                hover = Colors.White,
//                pressed = Colors.White,
//                disabled = Colors.Red
//            )
//        )
//    )
}

@App
@Composable
fun MyApp(content: @Composable () -> Unit) {
    SilkApp {
        val colorMode by ColorMode.currentState
        LaunchedEffect(colorMode) {
            localStorage.setItem(COLOR_MODE_KEY, colorMode.name)
        }

        Surface(
            modifier = SmoothColorStyle.toModifier().minHeight(100.vh)
        ) {
            content()
        }
    }
}
