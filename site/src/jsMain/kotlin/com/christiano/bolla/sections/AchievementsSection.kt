package com.christiano.bolla.sections

import androidx.compose.runtime.*
import com.christiano.bolla.components.AchievementCard
import com.christiano.bolla.models.Achievement
import com.christiano.bolla.models.Section
import com.christiano.bolla.models.Theme
import com.christiano.bolla.utils.Constants
import com.christiano.bolla.utils.ObserveViewportEntered
import com.christiano.bolla.utils.animateNumbers
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.px

@Composable
fun AchievementsSection() {
    Box(
        modifier = Modifier
            .id(Section.Achievements.id)
            .fillMaxWidth()
            .maxWidth(Constants.SECTION_WIDTH.px)
            .padding(topBottom = 100.px)
            .backgroundColor(Theme.LighterGray.rgb),
        contentAlignment = Alignment.Center
    ) {
        AchievementsContent()
    }
}

@Composable
fun AchievementsContent() {
    val breakpoint = rememberBreakpoint()
    val scope = rememberCoroutineScope()
    var viewportEntered by remember { mutableStateOf(false) }
    val animatedNumbers = remember { Achievement.values().map { 0 }.toMutableStateList() }

    ObserveViewportEntered(
        sectionId = Section.Achievements.id,
        distanceFromTop = 800.0
    ) {
        viewportEntered = true
        Achievement.values().forEach { achievement ->
            scope.launch {
                animateNumbers(
                    number = achievement.number,
                    onUpdate = {
                        animatedNumbers[achievement.ordinal] = it
                    }
                )
            }
        }
    }

    SimpleGrid(numColumns = numColumns(base = 1, md = 2, lg = 3)) {
        Achievement.values().forEach {
            AchievementCard(
                modifier = Modifier
                    .margin(
                        right = if (it == Achievement.values().last()) 0.px else {
                            if (breakpoint > Breakpoint.SM) 40.px else 0.px
                        },
                        bottom = if (breakpoint > Breakpoint.MD) 0.px else 40.px
                    ),
                animatedNumber = if (viewportEntered) animatedNumbers[it.ordinal] else 0,
                achievement = it
            )
        }
    }
}