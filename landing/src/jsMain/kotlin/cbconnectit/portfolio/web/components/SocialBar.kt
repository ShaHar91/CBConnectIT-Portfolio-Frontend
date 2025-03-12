package cbconnectit.portfolio.web.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import cbconnectit.portfolio.web.data.models.domain.Link
import cbconnectit.portfolio.web.data.models.enums.LinkIcon
import cbconnectit.portfolio.web.styles.SocialLinkStyle
import cbconnectit.portfolio.web.utils.Identifiers.SocialBar.socialIcon
import cbconnectit.portfolio.web.utils.Identifiers.SocialBar.socialLink
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.*

@Composable
fun SocialBar(
    row: Boolean = false,
    socialLinkSize: SocialLinkSize = SocialLinkSize.SM,
    links: List<Link> = emptyList(),
    itemGap: CSSLengthOrPercentageNumericValue
) {

    Box(
        Modifier
            .display(DisplayStyle.Flex)
            .flexDirection(if (row) FlexDirection.Row else FlexDirection.Column)
            .flexWrap(FlexWrap.Wrap)
            .justifyContent(JustifyContent.Center)
            .gap(itemGap)
    ) {
        SocialLinks(socialLinkSize, links)
    }
}

@Composable
private fun SocialLinks(
    socialLinkSize: SocialLinkSize = SocialLinkSize.SM,
    links: List<Link> = emptyList()
) {
    val colorMode by ColorMode.currentState

    links.forEach { link ->
        Link(
            modifier = SocialLinkStyle.toModifier()
                .textDecorationLine(TextDecorationLine.None),
            path = link.url,
            openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
        ) {
            Backdrop(
                colorMode,
                Modifier.id(socialLink)
                    .size(socialLinkSize.sizeValue)
                    .padding(10.px),
                borderRadius = 4.px
            ) {
                link.type.LinkIcon(
                    modifier = Modifier.id(socialIcon),
                    size = socialLinkSize.iconSize
                )
            }
        }

    }
}


enum class SocialLinkSize(val sizeValue: CSSSizeValue<CSSUnit.px>, val iconSize: IconSize) {
    SM(34.px, IconSize.SM),
    LG(44.px, IconSize.LG),
    XL(54.px, IconSize.XL)
}