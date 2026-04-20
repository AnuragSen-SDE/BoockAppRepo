package com.content.boockreaderapp.dashboard.bookDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.content.boockreaderapp.data.lolcal.entity.BookEntity

@Composable
fun BookDetailsContentScreen(
    innerPaddingValues: PaddingValues,
    book : BookEntity,
    navigateToBookReadingScreen : (Int) -> Unit
){

    val previewText = remember(book.content) {
        if (book.content.length > 200) {
            book.content.substring(0, 200) + "..."
        } else {
            book.content
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPaddingValues)
            .background(Color.White)
    ) {

        // Title
        Text(
            text = book.title,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Author
        Text(
            text = "by ${book.author}",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Summary / Preview content
        Text(
            text = previewText,
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.weight(1f)) // pushes button to bottom

        // Button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Button(
                onClick = { /* Bookmark action */ },
                modifier = Modifier.weight(1f)
            ) {
                Text("Bookmark")
            }

            Button(
                onClick = { navigateToBookReadingScreen.invoke(book.bookId) },
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = if (book.isStarted) "Continue Reading" else "Start Reading"
                )
            }
        }

    }

}