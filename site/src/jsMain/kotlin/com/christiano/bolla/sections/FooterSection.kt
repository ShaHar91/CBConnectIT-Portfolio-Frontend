package com.christiano.bolla.sections

import androidx.compose.runtime.Composable
import com.christiano.bolla.components.SocialBar
import com.christiano.bolla.models.Section
import com.christiano.bolla.styles.NavigationItemStyle
import com.christiano.bolla.utils.Constants
import com.christiano.bolla.utils.Res
import com.christiano.bolla.utils.logoImage
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun FooterSection(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .maxWidth(Constants.SECTION_WIDTH.px)
            .padding(topBottom = Constants.SECTION_PADDING.px)
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        FooterContent()
    }
}

@Composable
fun FooterContent() {
    val breakpoint = rememberBreakpoint()

    Column(
        modifier = Modifier
            .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 100.percent else 90.percent),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.width(110.px).padding(bottom = 25.px),
            src = logoImage(ColorMode.current),
            alt = "Logo Image"
        )

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
        SocialBar(true)
    }
}

@Composable
fun FooterMenu(row: Boolean = true) {
    Section.values().dropLast(2).forEach { sec ->
        Link(
            modifier = NavigationItemStyle.toModifier()
                .fontFamily(Constants.FONT_FAMILY)
                .padding(
                    right = if (row) 20.px else 0.px,
                    bottom = if (row) 0.px else 20.px
                )
                .fontSize(12.px)
                .fontWeight(FontWeight.Normal)
                .textDecorationLine(TextDecorationLine.None),
            path = sec.path,
            text = sec.title
        )
    }
}