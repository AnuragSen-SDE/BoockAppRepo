package com.content.boockreaderapp.dashboard.AllBooks

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.content.boockreaderapp.data.lolcal.entity.BookEntity

@Composable
fun BookListView(
    bookList : List<BookEntity>,
    paddingValues: PaddingValues,
    navigateToBookDetailScreen : (BookEntity) -> Unit
){

    Log.d("bookEntityData", "data - $bookList")

    LazyColumn(
        contentPadding = paddingValues
    ) {
        items(bookList) {
            book ->
            BookListCardView(book,navigateToBookDetailScreen)
        }
    }

}