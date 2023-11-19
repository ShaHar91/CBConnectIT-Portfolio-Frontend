package com.christiano.bolla.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.dom.Div

@Composable
fun Spacer(modifier: Modifier = Modifier) {
    Div(modifier.toAttrs())
}