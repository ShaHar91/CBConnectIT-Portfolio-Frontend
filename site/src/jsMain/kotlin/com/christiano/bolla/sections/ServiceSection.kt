package com.christiano.bolla.sections

import androidx.compose.runtime.Composable
import com.christiano.bolla.components.SectionTitle
import com.christiano.bolla.components.ServiceCard
import com.christiano.bolla.components.Spacer
import com.christiano.bolla.models.Section
import com.christiano.bolla.models.Service
import com.christiano.bolla.utils.Constants
import com.christiano.bolla.utils.Res
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.*

@Composable
fun ServiceSection() {
    Box(
        modifier = Modifier
            .id(Section.Service.id)
            .fillMaxWidth()
            .maxWidth(Constants.SECTION_WIDTH.px),
        contentAlignment = Alignment.Center
    ) {
        ServiceContent()
    }
}

@Composable
fun ServiceContent() {
    val breakpoint = rememberBreakpoint()

    @Composable
    fun ContentWrapper(content: @Composable () -> Unit) {
        if (breakpoint >= Breakpoint.MD) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 80.percent else 90.percent),
                verticalAlignment = Alignment.CenterVertically
            ) {
                content()
            }
        } else {
            Column(
                modifier = Modifier.fillMaxWidth(90.percent),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                content()
            }
        }
    }

    ContentWrapper {
        if (breakpoint >= Breakpoint.MD) {
            ServiceImage(breakpoint)

            Spacer(
                Modifier.width(
                    if (breakpoint > Breakpoint.MD) 100.px else 50.px
                )
            )
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            SectionTitle(
                modifier = Modifier.fillMaxWidth(),
                section = Section.Service,
                alignment = Alignment.Start,
                showSeeAllButton = true
            ) {
                //TODO: Add navigation!!
                println("Service section details!")
            }

            Spacer(Modifier.height(36.px))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .display(DisplayStyle.Flex)
                    .flexDirection(FlexDirection.Row)
                    .flexWrap(FlexWrap.Wrap)
                    .justifyContent(JustifyContent.SpaceAround)
            ) {
                Service.entries.forEach {
                    ServiceCard(
                        modifier = Modifier.fillMaxWidth(if (breakpoint >= Breakpoint.MD) 50.percent else 100.percent),
                        service = it
                    ) {
                        //TODO: Add navigation!!
                        println("${it.title} Service 'Read more' clicked")
                    }
                }
            }
        }

        if (breakpoint < Breakpoint.MD) {
            Spacer(Modifier.height(50.px))

            ServiceImage(breakpoint)
        }
    }
}

@Composable
fun ServiceImage(breakpoint: Breakpoint) {
    Image(
        modifier = Modifier
            .borderRadius(40.px)
            .width(if (breakpoint >= Breakpoint.MD) 30.percent else 60.percent)
            .aspectRatio(9, 16)
            .objectFit(ObjectFit.Cover),
        src = Res.Image.services,
        alt = "Services Image"
    )
}