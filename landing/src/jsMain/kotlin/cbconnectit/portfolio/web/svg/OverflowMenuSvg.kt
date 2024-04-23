package cbconnectit.portfolio.web.svg

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.dom.svg.Path
import com.varabyte.kobweb.compose.dom.svg.SVGFillRule
import com.varabyte.kobweb.compose.dom.svg.Svg
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.CSSColorValue

@Composable
fun overflowMenuSvg(
    fill: CSSColorValue,
    modifier: Modifier = Modifier,
) = Svg(attrs = modifier.toAttrs {
    width(24)
    height(24)
    viewBox(0, 0, 24, 24)
}) {
    Path {
        fillRule(SVGFillRule.EvenOdd)
        d("M3 8V6H21V8H3ZM3 13H21V11H3V13ZM3 18H21V16H3V18Z")
        fill(fill)
    }
}
