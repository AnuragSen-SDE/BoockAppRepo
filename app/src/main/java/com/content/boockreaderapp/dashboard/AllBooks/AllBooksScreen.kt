package com.content.boockreaderapp.dashboard.AllBooks

import android.provider.CalendarContract
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.content.boockreaderapp.data.lolcal.entity.BookEntity
import com.content.boockreaderapp.viewmodel.BookState
import com.content.boockreaderapp.viewmodel.MainViewModel
import java.nio.file.WatchEvent

@Composable
fun AllBooksScreen(
    mainViewModel : MainViewModel,
    innerPaddingValues: PaddingValues,
    navigateToBookDetailScreen : (BookEntity) -> Unit
){

    var searchQuery by remember { mutableStateOf("") }
    val state by mainViewModel.getAllBookState.collectAsState()
    LaunchedEffect(Unit) { mainViewModel.getAllBooks() }

    Column(
        modifier = Modifier.padding(innerPaddingValues)
            .fillMaxSize()
    ) {

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { query ->
                searchQuery = query
                mainViewModel.searchBook(query = query )
                            },
            modifier = Modifier.fillMaxWidth()
                .background(Color.LightGray),
            placeholder = {Text("Search By Author or Book Name")},
            singleLine =  true,
            shape = RoundedCornerShape(13.dp)
        )

        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
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