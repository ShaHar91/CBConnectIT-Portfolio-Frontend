package cbconnectit.portfolio.web.svg

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.dom.svg.Path
import com.varabyte.kobweb.compose.dom.svg.Svg
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.CSSColorValue

@Composable
fun tvAndroidSvg(
    fill: CSSColorValue,
    modifier: Modifier = Modifier,
) = Svg(attrs = modifier.toAttrs {
    width(24)
    height(24)
}) {

    Path {
        d("M21 3H3C1.9 3 1 3.9 1 5V17C1 18.1 1.9 19 3 19H8V21H16V19H21C22.1 19 22.99 18.1 22.99 17L23 5C23 3.9 22.1 3 21 3ZM21 17H3V5H21V17Z")
        fill(fill)
    }
    Path {
        d("M15.0545 9.27521L16.0582 7.51173C16.1455 7.33982 16.08 7.12909 15.9164 7.04036C15.7582 6.95718 15.5618 7.00709 15.4636 7.16236L14.4382 8.95911C12.8782 8.2881 11.1218 8.2881 9.56182 8.95911L8.53636 7.16236C8.43273 7.00154 8.22 6.95163 8.06182 7.05145C7.90909 7.15127 7.86 7.35091 7.94182 7.51173L8.94545 9.27521C7.25455 10.2568 6.15273 12.0258 6 14H18C17.8473 12.0258 16.7455 10.2568 15.0545 9.27521ZM9.27273 12.475C8.89636 12.475 8.59091 12.1644 8.59091 11.7818C8.59091 11.3991 8.89636 11.0886 9.27273 11.0886C9.64909 11.0886 9.95455 11.3991 9.95455 11.7818C9.95455 12.1644 9.64909 12.475 9.27273 12.475ZM14.7273 12.475C14.3509 12.475 14.0455 12.1644 14.0455 11.7818C14.0455 11.3991 14.3509 11.0886 14.7273 11.0886C15.1036 11.0886 15.4091 11.3991 15.4091 11.7818C15.4091 12.1644 15.1036 12.475 14.7273 12.475Z")
        fill(fill)
    }
}