package com.content.boockreaderapp.dashboard.AllBooks

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.content.boockreaderapp.data.lolcal.entity.BookEntity

@Composable
fun BookListCardView(
    bookDetail : BookEntity,
    navigateToBookDetailScreen : (BookEntity) -> Unit
){


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(enabled = true, onClick = {navigateToBookDetailScreen.invoke(bookDetail)}),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column {

            // 📷 Book Image
//            AsyncImage(
//                model = book.imageUrl, // make sure your entity has this
//                contentDescription = book.title,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(180.dp),
//                contentScale = ContentScale.Crop
//            )

            // 📝 Text Content
            Column(
                modifier = Modifier.padding(12.dp)
            ) {

                // 📚 Title
                Text(
                    text = bookDetail.title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    maxLines = 1
                )

                Spacer(modifier = Modifier.height(4.dp))

                // ✍️ Author
                Text(
                    text = "by ${bookDetail.author}",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.Gray,
                        fontStyle = FontStyle.Italic
                    )
                )
            }
        }
    }

}

//@Composable
//@Preview
//fun BookListCardPreview(){
//    BookListCardView(
//        BookEntity(
//            0,
//            "first book",
//            "auther",
//            false
//        )
//    )
//}