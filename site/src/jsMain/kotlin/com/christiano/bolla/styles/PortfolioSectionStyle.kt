package com.christiano.bolla.styles

import com.christiano.bolla.utils.Identifiers.PortfolioCard.boxParent
import com.christiano.bolla.utils.Identifiers.PortfolioCard.columnParent
import com.christiano.bolla.utils.Identifiers.PortfolioCard.greenOverlay
import com.christiano.bolla.utils.Identifiers.PortfolioCard.linkIcon
import com.christiano.bolla.utils.Identifiers.PortfolioCard.portfolioDesc
import com.christiano.bolla.utils.Identifiers.PortfolioCard.portfolioTitle
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

// Passing the animation through from the parent to a child can be done like this.
// Id's need to be added to the views and then can be accessed like this.
val PortfolioSectionStyle by ComponentStyle {
    cssRule(" > #$columnParent > #${boxParent} > #${greenOverlay}") {
        Modifier.width(0.px)
            .transition(CSSTransition(property = "width", duration = 500.ms))
    }

    cssRule(":hover > #$columnParent > #${boxParent} > #${greenOverlay}") {
        Modifier.width(300.px)
    }

    cssRule(" > #$columnParent > #${boxParent} > #${greenOverlay} > #${linkIcon}") {
        Modifier.visibility(Visibility.Hidden)
    }

    cssRule(":hover > #$columnParent > #${boxParent} > #${greenOverlay} > #${linkIcon}") {
        Modifier.visibility(Visibility.Visible)
    }

    cssRule(" > #$columnParent > #${portfolioTitle}") {
        Modifier
            .translateX(0.percent)
            .transition(
                CSSTransition(property = "color", duration = 200.ms),
                CSSTransition(property = "translate", duration = 200.ms)
            )
    }

    cssRule(":hover > #$columnParent > #${portfolioTitle}") {
        Modifier
            .translateX(5.percent)
    }

    cssRule(" > #$columnParent > #${portfolioDesc}") {
        Modifier
            .translateX(0.percent)
            .transition(CSSTransition(property = "translate", duration = 200.ms))
    }

    cssRule(":hover > #$columnParent > #${portfolioDesc}") {
        Modifier
            .translateX(5.percent)
    }
}

val PortfolioArrowIconStyle by ComponentStyle {
    base {
        Modifier.color(colorMode.toPalette().surface)
            .transition(CSSTransition(property = "color", duration = 200.ms))
    }

    hover {
        Modifier.color(colorMode.toPalette().primary)
    }
}