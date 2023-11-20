package com.christiano.bolla.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.christiano.bolla.styles.SocialLinkStyle
import com.christiano.bolla.utils.Constants
import com.christiano.bolla.utils.Identifiers.SocialBar.socialIcon
import com.christiano.bolla.utils.Identifiers.SocialBar.socialLink
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.components.icons.fa.FaLinkedin
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.px

@Composable
fun SocialBar(
    row: Boolean = false,
    socialLinkSize: SocialLinkSize = SocialLinkSize.SM,
) {
    if (row) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            SocialLinks(row, socialLinkSize)
        }
    } else {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            SocialLinks(row, socialLinkSize)
        }
    }
}

@Composable
private fun SocialLinks(
    row: Boolean = false,
    socialLinkSize: SocialLinkSize = SocialLinkSize.SM,
) {
    val colorMode by ColorMode.currentState

    Link(
        modifier = SocialLinkStyle.toModifier()
            .textDecorationLine(TextDecorationLine.None),
        path = Constants.GITHUB,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        Backdrop(
            colorMode,
            Modifier.id(socialLink)
                .size(socialLinkSize.sizeValue)
                .padding(10.px),
            borderRadius = 4.px
        ) {
            FaGithub(
                modifier = Modifier.id(socialIcon),
                size = socialLinkSize.iconSize
            )
        }
    }

    Spacer(Modifier
        .thenIf(row) { Modifier.width(20.px) }
        .thenIf(!row) { Modifier.height(20.px) }
    )

    Link(
        modifier = SocialLinkStyle.toModifier()
            .textDecorationLine(TextDecorationLine.None),
        path = Constants.LINKEDIN,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        Backdrop(
            colorMode,
            Modifier.id(socialLink)
                .size(socialLinkSize.sizeValue)
                .padding(10.px),
            borderRadius = 4.px
        ) {
            FaLinkedin(
                modifier = Modifier.id(socialIcon),
                size = socialLinkSize.iconSize
            )
        }
    }
}

enum class SocialLinkSize(val sizeValue: CSSSizeValue<CSSUnit.px>, val iconSize: IconSize) {
    SM(34.px, IconSize.SM),
    LG(44.px, IconSize.LG),
    XL(54.px, IconSize.XL)
}