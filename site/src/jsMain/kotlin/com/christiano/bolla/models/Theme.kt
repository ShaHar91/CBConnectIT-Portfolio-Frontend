package com.christiano.bolla.models

import com.varabyte.kobweb.compose.ui.graphics.Color
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb

enum class Theme(val hex: String, val rgb: CSSColorValue, val silkRgb: Color) {
    Primary(hex = "#00A78E", rgb = rgb(0, 65, 73), silkRgb = Color.rgb(0, 65, 73)),
    Secondary(hex = "121D34", rgb = rgb(17, 157, 164), silkRgb = Color.rgb(17, 157, 164)),
    Gray(hex = "#CFCFCF", rgb = rgb(r = 207, g = 207, b = 207), silkRgb = Color.rgb(r = 207, g = 207, b = 207)),
    LightGray(hex = "#EDEDED", rgb = rgb(r = 237, g = 237, b = 237), silkRgb = Color.rgb(r = 237, g = 237, b = 237)),
    LighterGray(hex = "#F9F9F9", rgb = rgb(r = 249, g = 249, b = 249), silkRgb = Color.rgb(r = 249, g = 249, b = 249));
}