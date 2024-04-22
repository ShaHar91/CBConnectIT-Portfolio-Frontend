package cbconnectit.portfolio.web.styles

import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.rotate
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms

val BackToTopButtonStyle by ComponentStyle {
    base {
        Modifier.rotate(a = 180.deg)
            .transition(CSSTransition("rotate", 300.ms))
    }
    hover {
        Modifier.rotate(a = 0.deg)
    }
}