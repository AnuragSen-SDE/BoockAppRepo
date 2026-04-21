package com.content.boockreaderapp.dashboard.bookReading

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.content.boockreaderapp.data.lolcal.entity.BookEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookReadingContentScreen(
    innerPaddingValues: PaddingValues,
    book : BookEntity
) {
    var fontSize by remember { mutableStateOf(18f) } // use Float for slider
    var showSheet by remember { mutableStateOf(false) }
    var darkMode by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    val darkColors = darkColorScheme(
        background = Color.Black,
        onBackground = Color.White,
        surface = Color(0xFF121212),
        onSurface = Color.White
    )

    val lightColors = lightColorScheme(
        background = Color.White,
        onBackground = Color.Black,
        surface = Color.White,
        onSurface = Color.Black
    )

    MaterialTheme(
        colorScheme = if (darkMode) darkColors else lightColors
    ) {
        // 🔹 Bottom Sheet
        if (showSheet) {
            ModalBottomSheet(
                onDismissRequest = { showSheet = false }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text("Dark Mode", fontSize = 12.sp)

                        Switch(
                            checked = darkMode,
                            onCheckedChange = {darkMode = it}
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Text Size",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text("A", fontSize = 12.sp)

                        Slider(
                            value = fontSize,
                            onValueChange = { fontSize = it },
                            valueRange = 12f..30f,
                            modifier = Modifier.weight(1f)
                        )

                        Text("A", fontSize = 26.sp)
                    }
                }
            }
        }

        // 🔹 Main UI
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(book.title) },
                    actions = {
                        IconButton(onClick = { showSheet = true }) {
                            Icon(Icons.Default.MoreVert, contentDescription = "More")
                        }
                    }
                )
            }
        ) { padding ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .verticalScroll(scrollState)
                    .padding(16.dp)
            ) {

                Text(
                    text = "by ${book.author}",
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = book.content,
                    fontSize = fontSize.sp,
                    lineHeight = (fontSize * 1.5f).sp,
                    textAlign = TextAlign.Justify
                )
            }
        }
    }


}