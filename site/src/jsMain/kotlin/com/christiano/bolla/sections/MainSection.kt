package com.christiano.bolla.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.christiano.bolla.components.Backdrop
import com.christiano.bolla.components.SocialBar
import com.christiano.bolla.components.SocialLinkSize
import com.christiano.bolla.components.Spacer
import com.christiano.bolla.models.Section
import com.christiano.bolla.models.Social
import com.christiano.bolla.styles.MainButtonStyle
import com.christiano.bolla.styles.MainImageStyle
import com.christiano.bolla.styles.primary
import com.christiano.bolla.utils.Constants.FONT_FAMILY
import com.christiano.bolla.utils.Constants.SECTION_WIDTH
import com.christiano.bolla.utils.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun MainSection() {
    Box(
        modifier = Modifier
            .id(Section.Home.id)
            .scrollMargin(60.px)
            .fillMaxWidth()
            .maxWidth(SECTION_WIDTH.px),
        contentAlignment = Alignment.TopCenter
    ) {
        MainContent()
    }
}

@Composable
fun MainContent() {
    val breakpoint = rememberBreakpoint()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // SimpleGrid will automatically use a column (horizontal) for bigger devices, or a row (vertical) for smaller devices
        SimpleGrid(
            modifier = Modifier.fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 80.percent else 90.percent
            ),
            numColumns = numColumns(base = 1, md = 2)
        ) {
            MainText(breakpoint)
            MainImage(breakpoint)
        }
    }
}

@Composable
fun MainText(breakpoint: Breakpoint) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val ctx = rememberPageContext()

        SocialBar(
            socialLinkSize = SocialLinkSize.LG,
            links = Social.entries.map { com.christiano.bolla.models.Link(it.type, it.link) },
            itemGap = 20.px
        )

        Spacer(Modifier.width(50.px))

        Column {
            if (breakpoint > Breakpoint.SM) {
                Spacer(Modifier.height(50.px))
            }

            P(
                attrs = Modifier
                    .margin(top = 0.px, bottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(if (breakpoint >= Breakpoint.LG) 36.px else 24.px)
                    .fontWeight(FontWeight.Normal)
                    .toAttrs()
            ) {
                Text("Hello, I am")
            }

            P(
                attrs = Modifier
                    .margin(top = 0.px, bottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(if (breakpoint >= Breakpoint.LG) 56.px else 36.px)
                    .color(ColorMode.current.toPalette().primary)
                    .fontWeight(FontWeight.Bolder)
                    .toAttrs()
            ) {
                Text("Christiano Bolla")
            }

            P(
                attrs = Modifier
                    .margin(top = 0.px, bottom = 5.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(22.px)
                    .fontWeight(FontWeight.Bold)
                    .toAttrs()
            ) {
                Text("Mobile Developer")
            }

            P(
                attrs = Modifier
                    .fillMaxWidth()
                    .margin(top = 0.px, bottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontWeight(FontWeight.Normal)
                    .toAttrs()
            ) {
                Text("I have been working since 2017 as an Android Developer. Proficient in turning an idea into a fully functioning and UI/UX stunning application")
            }

            Spacer(Modifier.height(40.px))

            Button(
                modifier = MainButtonStyle.toModifier(),
                onClick = {
                    ctx.router.tryRoutingTo(Section.Contact.path)
                }
            ) {
                Text("Let's chat!")
            }
        }
    }
}

@Composable
fun MainImage(breakpoint: Breakpoint) {
    Box(
        modifier = Modifier.fillMaxSize(100.percent),
        contentAlignment = if (breakpoint < Breakpoint.MD) Alignment.BottomCenter else Alignment.BottomEnd,
    ) {
        val colorMode by ColorMode.currentState

        Backdrop(
            colorMode, modifier = Modifier
                .fillMaxWidth(90.percent)
                .fillMaxHeight(85.percent)
                .maxWidth(if (breakpoint < Breakpoint.MD) 345.px else 400.px)
        )

        Image(
            modifier = MainImageStyle.toModifier()
                .fillMaxWidth(90.percent)
                .maxWidth(if (breakpoint < Breakpoint.MD) 345.px else 400.px),
            src = Res.Image.mainImage,
            alt = "Main Image"
        )
    }
}