package com.content.boockreaderapp.dashboard.bookDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import com.content.boockreaderapp.dashboard.AllBooks.BookListView
import com.content.boockreaderapp.data.lolcal.entity.BookEntity
import com.content.boockreaderapp.viewmodel.BookState
import com.content.boockreaderapp.viewmodel.MainViewModel

@Composable
fun BookDetailsScreen(
    bookId : Int,
    navController: NavHostController,
    innerPaddingValues: PaddingValues,
    mainViewModel: MainViewModel,
    navigateToBookReadingScreen : (Int) -> Unit
){

    val state = mainViewModel.getBookByIdState.collectAsState()
    LaunchedEffect(Unit) { mainViewModel.getBookById(bookId) }

    when(state.value){
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
            BookDetailsContentScreen(
                innerPaddingValues,
                (state.value as BookState.Success<BookEntity>).data,
                mainViewModel,
                navigateToBookReadingScreen
            )
        }
    }

//    Box(
//        modifier = Modifier.fillMaxSize()
//            .padding(innerPaddingValues),
//        contentAlignment = Alignment.Center
//    ) {
//        Text(
//            text = "Book Details Page",
//            fontSize = 20.sp,
//            fontFamily = FontFamily.Monospace,
//            fontStyle = FontStyle.Normal
//        )
//    }

}