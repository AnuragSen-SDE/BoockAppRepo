package com.content.boockreaderapp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.content.boockreaderapp.dashboard.bookDetails.BookDetailsScreen
import com.content.boockreaderapp.dashboard.bookReading.BookReadingScreen
import com.content.boockreaderapp.dashboard.DashboardScreen
import com.content.boockreaderapp.splash.SplashScreen
import com.content.boockreaderapp.viewmodel.AppStateState
import com.content.boockreaderapp.viewmodel.MainViewModel


@Composable
fun RootNavGraph(
    navController : NavHostController,
    innerPadding : PaddingValues,
    viewModel: MainViewModel
){

    NavHost(
        navController = navController,
        startDestination = SplashRoute
    ) {

        composable <SplashRoute> {
            val splashScreenState by viewModel.splashScreenState.collectAsState()

            LaunchedEffect(Unit) { viewModel.updateSplashState() }
            LaunchedEffect(splashScreenState) {
                when(splashScreenState) {
                    AppStateState.Idle -> {
                        navController.navigate(DashboardScreenRoute){
                            popUpTo(SplashRoute) {inclusive = true}
                        }
                    }
                    else -> {}
                }
            }
            SplashScreen(navController,innerPadding)
        }

        composable<BookDetailsRoute> { BookDetailsScreen(navController,innerPadding) }

        composable<BookReadingRoute> { BookReadingScreen(navController,innerPadding) }

        composable<DashboardScreenRoute> { DashboardScreen(viewModel,navController,innerPadding) }

    }

}