package cbconnectit.portfolio.web.styles

import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.rotate
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms

val BackToTopButtonStyle = CssStyle {
    base {
        Modifier.rotate(a = 180.deg)
            .transition(Transition.of("rotate", 300.ms))
    }
    hover {
        Modifier.rotate(a = 0.deg)
    }
}