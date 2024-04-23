package cbconnectit.portfolio.web.styles

import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.translateY
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val ServicesTypeCardStyle by ComponentStyle {
    base {
        Modifier.translateY(0.px)
            .transition(CSSTransition(property = "translate", duration = 200.ms))
    }

    hover {
        Modifier.translateY((-10).px)
    }
}
