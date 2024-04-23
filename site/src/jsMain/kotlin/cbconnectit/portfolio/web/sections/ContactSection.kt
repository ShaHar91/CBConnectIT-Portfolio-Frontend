package cbconnectit.portfolio.web.sections

import androidx.compose.runtime.*
import cbconnectit.portfolio.web.components.ContactForm
import cbconnectit.portfolio.web.components.SectionTitle
import cbconnectit.portfolio.web.components.Spacer
import cbconnectit.portfolio.web.models.enums.Section
import cbconnectit.portfolio.web.styles.secondaryContainer
import cbconnectit.portfolio.web.utils.Identifiers.PropertyName.transform
import cbconnectit.portfolio.web.utils.ObserveViewportEntered
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

@Composable
fun ContactSection() {
    Box(
        modifier = Modifier
            .id(Section.Contact.id)
            .scrollMargin(80.px)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        ContactContent()
    }
}

@OptIn(ExperimentalComposeWebApi::class)
@Composable
fun ContactContent() {
    val colorMode by ColorMode.currentState

    val breakpoint = rememberBreakpoint()

    val scope = rememberCoroutineScope()
    var animatedRotation by remember { mutableStateOf(0.deg) }

    ObserveViewportEntered(
        sectionId = Section.Contact.id,
        distanceFromTop = 500.0
    ) {
        animatedRotation = 10.deg
        scope.launch {
            delay(500)
            animatedRotation = 0.deg
        }
    }

    Column(
        modifier = Modifier
            .backgroundColor(colorMode.toPalette().secondaryContainer)
            .fillMaxWidth()
            .padding(topBottom = 24.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier
                .fillMaxWidth()
                .transform { rotate(animatedRotation) }
                .transition(CSSTransition(transform, 500.ms)),
            section = Section.Contact,
            alignment = Alignment.CenterHorizontally
        )

        Spacer(Modifier.height(24.px))

        ContactForm(breakpoint)
    }
}