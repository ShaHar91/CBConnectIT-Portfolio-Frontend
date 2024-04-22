package cbconnectit.portfolio.web.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import cbconnectit.portfolio.web.components.HighLightCard
import cbconnectit.portfolio.web.components.SectionTitle
import cbconnectit.portfolio.web.components.Spacer
import cbconnectit.portfolio.web.models.Section
import cbconnectit.portfolio.web.styles.onSecondaryContainer
import cbconnectit.portfolio.web.styles.onSurface
import cbconnectit.portfolio.web.styles.secondaryContainer
import cbconnectit.portfolio.web.svg.completedProjectsSvg
import cbconnectit.portfolio.web.svg.experienceSvg
import cbconnectit.portfolio.web.utils.Constants
import cbconnectit.portfolio.web.utils.Res
import cbconnectit.portfolio.web.utils.format
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
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
            .scrollMargin(80.px)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        AboutContent()
    }
}

@Composable
fun AboutContent() {
    val colorMode by ColorMode.currentState

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .color(colorMode.toPalette().onSecondaryContainer)
            .backgroundColor(colorMode.toPalette().secondaryContainer)
            .padding(topBottom = 32.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier.fillMaxWidth(),
            section = Section.About,
            alignment = Alignment.CenterHorizontally
        )

        Spacer(Modifier.height(36.px))

        P(
            attrs = Modifier
                .fillMaxWidth(80.percent)
                .maxWidth(780.px)
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(16.px)
                .textAlign(TextAlign.Center)
                .fontWeight(FontWeight.Normal)
                .toAttrs()
        ) {
            Text(Res.String.AboutContent)
        }

        Spacer(Modifier.height(36.px))

        Row {
            val started = Date.UTC(2017, 11).toDuration(DurationUnit.MILLISECONDS)
            val current = Date.now().toDuration(DurationUnit.MILLISECONDS)

            val yearsExperience = (current - started).inWholeDays / 365

            HighLightCard(colorMode, Res.String.Experience, Res.String.ExperienceInYears.format(yearsExperience)) {
                experienceSvg(colorMode.toPalette().onSurface)
            }

            Spacer(Modifier.width(16.px))

            HighLightCard(colorMode, Res.String.Completed, Res.String.CompletedProjects) {
                completedProjectsSvg(colorMode.toPalette().onSurface)
            }
        }
    }
}
