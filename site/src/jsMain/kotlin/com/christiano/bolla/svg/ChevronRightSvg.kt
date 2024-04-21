package com.christiano.bolla.svg

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.dom.svg.Path
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.IconRenderStyle
import com.varabyte.kobweb.silk.components.icons.createIcon

@Composable
fun chevronRightSvg(modifier: Modifier = Modifier) =
    createIcon(renderStyle = IconRenderStyle.Fill(), attrs = modifier.toAttrs()) {
        Path {
            d {
                moveTo(10, 6)
                lineTo(8.59, 7.41)
                lineTo(13.17, 12)
                lineTo(-4.58, 4.59, true)
                lineTo(10, 18)
                lineTo(6, -6, true)
                closePath()
            }
        }
    }
