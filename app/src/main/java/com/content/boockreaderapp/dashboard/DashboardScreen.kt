package com.content.boockreaderapp.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.content.boockreaderapp.dashboard.AllBooks.AllBooksScreen
import com.content.boockreaderapp.dashboard.bookmarkedBooks.BookmarkedBookScreen
import com.content.boockreaderapp.navigation.AllBooksScreenRoute
import com.content.boockreaderapp.navigation.BookmarkedScreenRoute

@Composable
fun DashboardScreen(
    navController: NavHostController,
    innerPaddingValues: PaddingValues
){
    val bottomNavController = rememberNavController()

    Scaffold(
        bottomBar =  {
            DashboardBottomNav(bottomNavController)
        }
    ) { innerPadding  ->

        NavHost(
            bottomNavController,
            startDestination = AllBooksScreenRoute
        ) {

            composable <AllBooksScreenRoute> {
                AllBooksScreen(innerPadding)
            }

            composable <BookmarkedScreenRoute> { BookmarkedBookScreen(innerPadding) }

        }

    }



}