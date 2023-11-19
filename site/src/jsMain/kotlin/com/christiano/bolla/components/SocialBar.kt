package com.christiano.bolla.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.christiano.bolla.styles.SocialLinkStyle
import com.christiano.bolla.utils.Constants
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.components.icons.fa.FaLinkedin
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.px

@Composable
fun SocialBar(row: Boolean = false) {
    if (row) {
        Row(
            modifier = Modifier
                .margin(top = 25.px)
                .padding(leftRight = 25.px),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            SocialLinks(row)
        }
    } else {
        Column(
            modifier = Modifier
                .margin(right = 25.px)
                .padding(topBottom = 25.px),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            SocialLinks(row)
        }
    }
}

@Composable
private fun SocialLinks(row: Boolean = false) {
    val colorMode by ColorMode.currentState

    Link(
        modifier = SocialLinkStyle.toModifier()
            .textDecorationLine(TextDecorationLine.None),
        path = Constants.GITHUB,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        Backdrop(
            colorMode,
            Modifier.id("socialLink")
                .size(45.px)
                .padding(10.px)
                .margin(
                    bottom = if (row) 0.px else 20.px,
                    right = if (row) 20.px else 0.px
                ),
            borderRadius = 4.px
        ) {
            FaGithub(
                modifier = Modifier.id("socialIcon"),
                size = IconSize.LG
            )
        }
    }

    Link(
        modifier = SocialLinkStyle.toModifier()
            .textDecorationLine(TextDecorationLine.None),
        path = Constants.LINKEDIN,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        Backdrop(
            colorMode,
            Modifier.id("socialLink")
                .size(45.px)
                .padding(10.px),
            borderRadius = 4.px
        ) {
            FaLinkedin(
                modifier = Modifier.id("socialIcon"),
                size = IconSize.LG
            )
        }
    }
}