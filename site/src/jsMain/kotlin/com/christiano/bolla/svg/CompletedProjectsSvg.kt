package com.christiano.bolla.svg

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.dom.svg.Path
import com.varabyte.kobweb.compose.dom.svg.SVGFillRule
import com.varabyte.kobweb.compose.dom.svg.Svg
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.CSSColorValue

@Composable
fun completedProjectsSvg(
    fill: CSSColorValue,
    modifier: Modifier = Modifier
) = Svg(attrs = modifier.toAttrs {
    width(24)
    height(24)
    viewBox(0, 0, 24, 24)
}) {
    Path {
        d("M20 3H4C2.9 3 2 3.9 2 5V19C2 20.1 2.9 21 4 21H20C21.1 21 22 20.1 22 19V5C22 3.9 21.1 3 20 3ZM10 17H5V15H10V17ZM10 13H5V11H10V13ZM10 9H5V7H10V9ZM14.82 15L12 12.16L13.41 10.75L14.82 12.17L17.99 9L19.41 10.42L14.82 15Z")
        fillRule(SVGFillRule.EvenOdd)
        fill(fill)
    }
}