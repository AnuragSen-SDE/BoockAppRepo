package com.content.boockreaderapp.dashboard.AllBooks

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import com.content.boockreaderapp.data.lolcal.entity.BookEntity
import com.content.boockreaderapp.viewmodel.BookState
import com.content.boockreaderapp.viewmodel.MainViewModel

@Composable
fun AllBooksScreen(
    mainViewModel : MainViewModel,
    innerPaddingValues: PaddingValues,
    navigateToBookDetailScreen : (BookEntity) -> Unit
){

    val state by mainViewModel.getAllBookState.collectAsState()
    LaunchedEffect(Unit) { mainViewModel.getAllBooks() }

    when(state){
        is BookState.Loading -> {
            CircularProgressIndicator()
        }
        is BookState.Empty -> {
            Text("No Books Avilable")
        }
        is BookState.Error -> {
            Text("Something went wrong")
        }
        is BookState.Success -> {
            BookListView(
                bookList = (state as BookState.Success<List<BookEntity>>).data,
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
//            text = "All Book Page",
//            fontSize = 20.sp,
//            fontFamily = FontFamily.Monospace,
//            fontStyle = FontStyle.Normal
//        )
//    }
}