package com.christiano.bolla.sections

import androidx.compose.runtime.*
import com.christiano.bolla.components.Backdrop
import com.christiano.bolla.components.SectionTitle
import com.christiano.bolla.components.SkillBar
import com.christiano.bolla.models.Section
import com.christiano.bolla.models.Skill
import com.christiano.bolla.styles.AboutImageStyle
import com.christiano.bolla.styles.AboutTextStyle
import com.christiano.bolla.styles.SocialLinkStyle
import com.christiano.bolla.utils.Constants
import com.christiano.bolla.utils.ObserveViewportEntered
import com.christiano.bolla.utils.Res
import com.christiano.bolla.utils.animateNumbers
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaAddressBook
import com.varabyte.kobweb.silk.components.icons.fa.FaAward
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import kotlin.js.Date
import kotlin.time.DurationUnit
import kotlin.time.toDuration

@Composable
fun AboutSection() {
    Box(
        modifier = Modifier
            .id(Section.About.id)
            .maxWidth(Constants.SECTION_WIDTH.px)
            .margin(top = Constants.SECTION_PADDING.px)
            .padding(top = Constants.SECTION_PADDING.px),
        contentAlignment = Alignment.Center
    ) {
        AboutContent()
    }
}

@Composable
fun AboutContent() {
    val breakpoint = rememberBreakpoint()

    Column(
        modifier = Modifier
            .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 100.percent else 90.percent)
            .maxWidth(1200.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SimpleGrid(
            modifier = Modifier.fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 90.percent else 100.percent
            ),
            numColumns = numColumns(base = 1, md = 2)
        ) {
            if (breakpoint >= Breakpoint.MD) {
                AboutImage()
            }
            AboutMe()
        }
    }
}

@Composable
fun AboutImage() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = AboutImageStyle.toModifier().fillMaxWidth(80.percent),
            src = Res.Image.about,
            alt = "About Image"
        )
    }
}

@Composable
fun AboutMe() {
    val scope = rememberCoroutineScope()
    var viewportEntered by remember { mutableStateOf(false) }
    val animatedPercentage = remember { Skill.entries.map { 0 }.toMutableStateList() }

    ObserveViewportEntered(
        sectionId = Section.About.id,
        distanceFromTop = 300.0
    ) {
        viewportEntered = true
        Skill.values().forEach { skill ->
            scope.launch {
                animateNumbers(
                    number = skill.percentage.value.toInt(),
                    onUpdate = {
                        animatedPercentage[skill.ordinal] = it
                    }
                )
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        SectionTitle(section = Section.About)

        P(
            attrs = Modifier
                .margin(topBottom = 25.px)
                .maxWidth(500.px)
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(18.px)
                .fontWeight(FontWeight.Normal)
                .toAttrs()
        ) {
            Text("Skilled Android Developer with over 5 years of experience in developing applications using Java and Kotlin. Someone who has a passion for staying up-to-date with all new technologies, constantly seeking to explore and take advantage of the latest advancements in the Android Framework. Committed to delivering robust, user-friendly, and scalable applications. A fast learner with an ability to adapt quickly to new technologies and a strong focus for code quality and best practices.")
        }

        Row {
            val colorMode by ColorMode.currentState

            Backdrop(colorMode) {
                Column {
                    FaAward(
                        size = IconSize.LG
                    )

                    P() {
                        Text("Experience")
                    }

                    P {
                        val started = Date.UTC(2017, 11).toDuration(DurationUnit.MILLISECONDS)
                        val current = Date.now().toDuration(DurationUnit.MILLISECONDS)

                        val yearsExperience = (current - started).inWholeDays / 365

                        Text("$yearsExperience years")
                    }
                }
            }

            Backdrop(colorMode) {
                Column {
                    FaAddressBook(
                        size = IconSize.LG
                    )

                    P() {
                        Text("Experience")
                    }

                    P {
                        val started = Date.UTC(2017, 11).toDuration(DurationUnit.MILLISECONDS)
                        val current = Date.now().toDuration(DurationUnit.MILLISECONDS)

                        val yearsExperience = (current - started).inWholeDays / 365

                        Text("$yearsExperience years")
                    }
                }
            }

            Backdrop(colorMode) {
                Column {
                    FaAward(
                        size = IconSize.LG
                    )

                    P() {
                        Text("Experience")
                    }

                    P {
                        val started = Date.UTC(2017, 11).toDuration(DurationUnit.MILLISECONDS)
                        val current = Date.now().toDuration(DurationUnit.MILLISECONDS)

                        val yearsExperience = (current - started).inWholeDays / 365

                        Text("$yearsExperience years")
                    }
                }
            }
        }

//        Skill.values().forEach {
//            SkillBar(
//                it.title,
//                it.ordinal,
//                if (viewportEntered) it.percentage else 0.percent,
//                animatedPercentage = if (viewportEntered) animatedPercentage[it.ordinal] else 0
//            )
//        }
    }
}