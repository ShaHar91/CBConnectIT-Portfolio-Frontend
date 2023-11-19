package com.christiano.bolla.utils

import androidx.compose.runtime.*
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.delay
import org.w3c.dom.events.EventListener

@Composable
fun ObserveViewportEntered(
    sectionId: String,
    distanceFromTop: Double,
    onViewPortEntered: () -> Unit
) {
    var viewportEntered by remember { mutableStateOf(false) }
    val listener = remember {
        EventListener {
            window.screen.height
            val top = document.getElementById(sectionId)?.getBoundingClientRect()?.top
            if (top != null && top < distanceFromTop) {
                viewportEntered = true
            }
        }
    }

    LaunchedEffect(viewportEntered) {
        if (viewportEntered) {
            onViewPortEntered()
            window.removeEventListener(type = "scroll", callback = listener)
        } else {
            window.addEventListener(type = "scroll", callback = listener)
        }
    }
}

suspend fun animateNumbers(
    number: Int,
    delay: Long = 10L,
    onUpdate: (Int) -> Unit
) {
    (0..number).forEach {
        delay(delay)
        onUpdate(it)
    }
}

fun logoImage(colorMode: ColorMode) = when (colorMode) {
    ColorMode.DARK -> Res.Image.logoDark
    ColorMode.LIGHT -> Res.Image.logo
}