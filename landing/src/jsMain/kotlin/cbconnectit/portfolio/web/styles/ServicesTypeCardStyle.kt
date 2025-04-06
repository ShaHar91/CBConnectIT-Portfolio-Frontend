package cbconnectit.portfolio.web.styles

import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.translateY
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val ServicesTypeCardStyle = CssStyle {
    base {
        Modifier.translateY(0.px)
            .transition(Transition.of(property = "translate", duration = 200.ms))
    }

    hover {
        Modifier.translateY((-10).px)
    }
}
