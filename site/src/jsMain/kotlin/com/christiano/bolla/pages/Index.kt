package com.christiano.bolla.pages

import androidx.compose.runtime.*
import com.christiano.bolla.components.BackToTopButton
import com.christiano.bolla.components.OverlowMenu
import com.christiano.bolla.sections.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page

@Page
@Composable
fun HomePage() {
    var menuOpened by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            Modifier.fillMaxSize(),
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
            TestimonialSection()
            ExperienceSection()
            ContactSection()
            FooterSection()
        }

        BackToTopButton()

        if (menuOpened) {
            OverlowMenu { menuOpened = false }
        }
    }
}