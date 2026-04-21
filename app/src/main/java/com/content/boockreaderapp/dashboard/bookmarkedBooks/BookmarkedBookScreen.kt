package com.content.boockreaderapp.dashboard.bookmarkedBooks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.content.boockreaderapp.dashboard.AllBooks.BookListView
import com.content.boockreaderapp.data.lolcal.entity.BookEntity
import com.content.boockreaderapp.viewmodel.BookState
import com.content.boockreaderapp.viewmodel.MainViewModel

@Composable
fun BookmarkedBookScreen(
    innerPaddingValues: PaddingValues,
    mainViewModel: MainViewModel,
    navigateToBookDetailScreen : (BookEntity) -> Unit
){

    val state by mainViewModel.getAllBookmarkedBookState.collectAsState()
    LaunchedEffect(Unit) { mainViewModel.getAllBookmarkedBooks() }

    Column(
        modifier = Modifier.padding(innerPaddingValues)
            .fillMaxSize()
    ) {

        when (val currentState = state) {

            is BookState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is BookState.Empty -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No Books Available")
                }
            }

            is BookState.Error -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Something went wrong")
                }
            }

            is BookState.Success -> {
                // ✅ NO Box here → so list starts from top
                BookListView(
                    bookList = currentState.data,
                    innerPaddingValues,
                    navigateToBookDetailScreen
                )
            }
        }

//    Box(
//        modifier = Modifier.fillMaxSize()
//            .padding(innerPaddingValues),
//        contentAlignment = Alignment.Center
//    ) {
//        Text(
//            text = "Bookmarked Page",
//            fontSize = 20.sp,
//            fontFamily = FontFamily.Monospace,
//            fontStyle = FontStyle.Normal
//        )
    }
}