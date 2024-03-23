package com.christiano.bolla.sections

import androidx.compose.runtime.Composable
import com.christiano.bolla.components.SocialBar
import com.christiano.bolla.components.Spacer
import com.christiano.bolla.models.Section
import com.christiano.bolla.models.Social
import com.christiano.bolla.styles.NavigationItemStyle
import com.christiano.bolla.utils.Constants
import com.christiano.bolla.utils.logoImage
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.px

@Composable
fun FooterSection(showMenu: Boolean, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .maxWidth(Constants.SECTION_WIDTH.px)
            .padding(topBottom = 32.px)
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        FooterContent(showMenu)
    }
}

@Composable
fun FooterContent(showMenu: Boolean) {
    val breakpoint = rememberBreakpoint()

    Column(
        modifier = Modifier.fillMaxWidth(/*if (breakpoint >= Breakpoint.MD) 100.percent else 90.percent*/),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.width(110.px),
            src = logoImage(ColorMode.current),
            alt = "Logo Image"
        )

        Spacer(Modifier.height(25.px))

        if (showMenu) {
            // simple grid can't be used since it only allows up to 5 items
            if (breakpoint > Breakpoint.SM) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    FooterMenu()
                }
            } else {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    FooterMenu(row = false)
                }
            }
        }

        Spacer(Modifier.height(25.px))

        SocialBar(
            row = true,
            links = Social.entries.map { com.christiano.bolla.models.LinkOld(it.type, it.link) },
            itemGap = 20.px
        )
    }
}

@Composable
fun FooterMenu(row: Boolean = true) {
    Section.entries.dropLast(2).forEachIndexed { index, section ->
        if (index != 0) {
            Spacer(Modifier
                .thenIf(row) { Modifier.width(20.px) }
                .thenIf(!row) { Modifier.height(20.px) }
            )
        }

        Link(
            modifier = NavigationItemStyle.toModifier()
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(12.px)
                .fontWeight(FontWeight.Normal)
                .textDecorationLine(TextDecorationLine.None),
            path = section.path,
            text = section.title
        )
    }
}