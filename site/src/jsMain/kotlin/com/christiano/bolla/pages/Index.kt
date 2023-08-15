package com.christiano.bolla.pages

import androidx.compose.runtime.*
import com.christiano.bolla.components.BackToTopButton
import com.christiano.bolla.components.Header
import com.christiano.bolla.components.OverlowMenu
import com.christiano.bolla.sections.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.px

@Page
@Composable
fun HomePage() {
    var menuOpened by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Header { menuOpened = true }
        }

        Column(
            Modifier.fillMaxSize().padding(top = 50.px),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MainSection {
                menuOpened = true
            }
            AboutSection()
            ServiceSection()
            PortfolioSection()
            AchievementsSection()
//            TestimonialSection() // TODO: something is wrong with this section, using this will make the header behave strange!
//            ExperienceSection() // TODO: something is wrong with this section, using this will make the header behave strange!
//            ContactSection() // TODO: something is wrong with this section, using this will make the header behave strange!
            FooterSection()
        }

        BackToTopButton()

        if (menuOpened) {
            OverlowMenu { menuOpened = false }
        }
    }
}