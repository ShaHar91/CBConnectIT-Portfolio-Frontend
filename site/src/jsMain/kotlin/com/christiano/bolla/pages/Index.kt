package com.christiano.bolla.pages

import androidx.compose.runtime.*
import com.christiano.bolla.components.BackToTopButton
import com.christiano.bolla.components.Header
import com.christiano.bolla.components.OverlowMenu
import com.christiano.bolla.components.Spacer
import com.christiano.bolla.sections.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.gridRow
import com.varabyte.kobweb.compose.ui.modifiers.gridTemplateRows
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.css.px

@Page
@Composable
fun HomePage() {
    var menuOpened by remember { mutableStateOf(false) }
    val breakpoint = rememberBreakpoint()

    val spacerHeight = when {
        breakpoint > Breakpoint.MD -> 100.px
        breakpoint == Breakpoint.MD -> 80.px
        else -> 50.px
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        PageLayout("Home",
            onMenuClicked = {
                menuOpened = true
            }
        ) {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(Modifier.height(if (breakpoint < Breakpoint.MD) 56.px else 12.px))

                MainSection()

                Spacer(Modifier.height(spacerHeight))

                AboutSection()

                Spacer(Modifier.height(spacerHeight))

                ServiceSection()

                Spacer(Modifier.height(spacerHeight))

                PortfolioSection()

                Spacer(Modifier.height(spacerHeight))

                TestimonialSection()// TODO: Makes the page wider on a smaller screen size (my phone landscape)

                Spacer(Modifier.height(spacerHeight))

//                AchievementsContent()
//
//                Spacer(Modifier.height(spacerHeight))

                ExperienceSection()

                Spacer(Modifier.height(spacerHeight))

                ContactSection()

                Spacer(Modifier.height(52.px))
            }
        }

//        * var showModal by remember { mutableStateOf(true) }
//        * if (showModal) {
//        *   Overlay(Modifier.onClick { showModal = false }) {
//            *     Dialog {
//            *        // ... your modal content here ...
//            *     }
//            *   }
//        * }

        BackToTopButton()

        if (menuOpened) {
            OverlowMenu { menuOpened = false }
        }
    }
}

@Composable
fun PageLayout(title: String, showMenu: Boolean = true, onMenuClicked: () -> Unit, content: @Composable () -> Unit) {
    LaunchedEffect(title) {
        document.title = "Kobweb - $title"
    }

    // Create a box with two rows: the main content (fills as much space as it can) and the footer (which reserves
    // space at the bottom). "auto" means the use the height of the row. "1fr" means give the rest of the space to
    // that row. Since this box is set to *at least* 100%, the footer will always appear at least on the bottom but
    // can be pushed further down if the first row grows beyond the page.
    Box(
        Modifier.fillMaxSize().gridTemplateRows { size(1.fr); size(auto) },
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxSize().align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Header(showMenu) { onMenuClicked() }
            content()
        }
        // Associate the footer with the row that will get pushed off the bottom of the page if it can't fit.
        FooterSection(showMenu, Modifier.gridRow(2, 3))
    }
}