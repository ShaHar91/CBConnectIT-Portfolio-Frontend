package com.christiano.bolla.components

import androidx.compose.runtime.*
import com.christiano.bolla.models.Section
import com.christiano.bolla.styles.primary
import com.christiano.bolla.utils.Constants
import com.christiano.bolla.utils.ObserveViewportEntered
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SectionTitle(
    modifier: Modifier = Modifier,
    section: Section,
    alignment: Alignment.Horizontal = Alignment.Start
) {
    val scope = rememberCoroutineScope()
    var titleMargin by remember { mutableStateOf(150.px) }
    var subtitleMargin by remember { mutableStateOf(200.px) }
    var dividerMargin by remember { mutableStateOf(300.px) }

    ObserveViewportEntered(
        sectionId = section.id,
        distanceFromTop = 700.0
    ) {
        scope.launch {
            titleMargin = 0.px
            subtitleMargin = 0.px
            dividerMargin = 0.px
        }
    }

    Column(
        modifier = modifier,
        horizontalAlignment = alignment
    ) {
        val textAlignment = when (alignment) {
            Alignment.Start -> TextAlign.Start
            Alignment.End -> TextAlign.End
            else -> TextAlign.Center
        }
        P(
            attrs = Modifier
                .fillMaxWidth()
                .textAlign(textAlignment)
                .margin(
                    top = 0.px,
                    bottom = 0.px,
                    left = if (alignment != Alignment.End) titleMargin else 0.px,
                    right = if (alignment == Alignment.End) titleMargin else 0.px,
                )
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(16.px)
                .fontWeight(FontWeight.Normal)
                .transition(CSSTransition("margin", 1000.ms))
                .toAttrs()
        ) {
            Text(section.title)
        }

        Spacer(Modifier.height(8.px))

        P(
            attrs = Modifier
                .fillMaxWidth()
                .textAlign(textAlignment)
                .margin(
                    left = if (alignment != Alignment.End) subtitleMargin else 0.px,
                    right = if (alignment == Alignment.End) subtitleMargin else 0.px,
                    top = 0.px,
                    bottom = 0.px
                )
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(28.px)
                .fontWeight(FontWeight.Bold)
                .transition(CSSTransition("margin", 1000.ms))
                .toAttrs()
        ) {
            Text(section.subtitle)
        }

        Spacer(Modifier.height(8.px))

        Box(
            modifier = Modifier
                .height(2.px)
                .width(80.px)
                .backgroundColor(ColorMode.current.toPalette().primary)
                .borderRadius(r = 50.px)
                .margin(
                    left = if (alignment != Alignment.End) dividerMargin else 0.px,
                    right = if (alignment == Alignment.End) dividerMargin else 0.px,
                )
                .transition(CSSTransition("margin", 1000.ms))
        )
    }
}