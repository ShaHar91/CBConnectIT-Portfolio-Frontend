package com.christiano.bolla.svg

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.dom.svg.Group
import com.varabyte.kobweb.compose.dom.svg.Path
import com.varabyte.kobweb.compose.dom.svg.SVGFillRule
import com.varabyte.kobweb.compose.dom.svg.Svg
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.CSSColorValue

@Composable
fun phoneAndroidSvg(
    fill: CSSColorValue,
    modifier: Modifier = Modifier,
) = Svg(attrs = modifier.toAttrs {
    width(24)
    height(24)
}) {

    Path {
        d("M16 1H8C6.34 1 5 2.34 5 4V20C5 21.66 6.34 23 8 23H16C17.66 23 19 21.66 19 20V4C19 2.34 17.66 1 16 1ZM14 21H10V20H14V21ZM17.25 18H6.75V4H17.25V18Z")
        fill(fill)
    }
    Path {
        d("M14.1 8.94997L14.79 7.62497C14.85 7.4958 14.805 7.33747 14.6925 7.2708C14.5838 7.2083 14.4488 7.2458 14.3813 7.36247L13.6762 8.71247C12.6037 8.2083 11.3963 8.2083 10.3238 8.71247L9.61875 7.36247C9.5475 7.24164 9.40125 7.20414 9.2925 7.27914C9.1875 7.35414 9.15375 7.50414 9.21 7.62497L9.9 8.94997C8.7375 9.68747 7.98 11.0166 7.875 12.5H16.125C16.02 11.0166 15.2625 9.68747 14.1 8.94997ZM10.125 11.3541C9.86625 11.3541 9.65625 11.1208 9.65625 10.8333C9.65625 10.5458 9.86625 10.3125 10.125 10.3125C10.3837 10.3125 10.5938 10.5458 10.5938 10.8333C10.5938 11.1208 10.3837 11.3541 10.125 11.3541ZM13.875 11.3541C13.6163 11.3541 13.4062 11.1208 13.4062 10.8333C13.4062 10.5458 13.6163 10.3125 13.875 10.3125C14.1337 10.3125 14.3438 10.5458 14.3438 10.8333C14.3438 11.1208 14.1337 11.3541 13.875 11.3541Z")
        fill(fill)
    }
}