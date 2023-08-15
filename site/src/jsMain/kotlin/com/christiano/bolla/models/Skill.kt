package com.christiano.bolla.models

import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.percent

enum class Skill(
    val title: String,
    val percentage: CSSSizeValue<CSSUnit.percent>
) {
    Creative("Creative", 90.percent),
    Accountable("Accountable", 90.percent),
    HardWorking("Hard Working", 80.percent),
    Value("Value for Money", 85.percent),
    Delivery("On-Time Delivery", 75.percent)
}