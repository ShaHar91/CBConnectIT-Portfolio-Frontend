package com.christiano.bolla.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.christiano.bolla.models.Achievement
import com.christiano.bolla.utils.Constants
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun AchievementCard(
    modifier: Modifier = Modifier,
    animatedNumber: Int,
    achievement: Achievement
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val colorMode by ColorMode.currentState

        Image(
            modifier = Modifier
                .size(70.px)
//                .color(colorMode.)
                .margin(right = 20.px),
            src = achievement.icon,
            alt = "Achievement Icon"
        )

        Column {
            P(
                attrs = Modifier
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(30.px)
                    .fontWeight(FontWeight.Bolder)
                    .toAttrs()
            ) {
                Text(
                    if (achievement == Achievement.Completed) "$animatedNumber+" else "$animatedNumber"
                )
            }

            P(
                attrs = Modifier
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(16.px)
                    .fontWeight(FontWeight.Normal)
                    .opacity(50.percent)
                    .toAttrs()
            ) {
                Text(achievement.description)
            }
        }
    }
}