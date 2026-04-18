package com.content.boockreaderapp.dashboard.bookmarkedBooks

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp

@Composable
fun BookmarkedBookScreen(
    innerPaddingValues: PaddingValues
){
    Box(
        modifier = Modifier.fillMaxSize()
            .padding(innerPaddingValues),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Bookmarked Page",
            fontSize = 20.sp,
            fontFamily = FontFamily.Monospace,
            fontStyle = FontStyle.Normal
        )
    }
}