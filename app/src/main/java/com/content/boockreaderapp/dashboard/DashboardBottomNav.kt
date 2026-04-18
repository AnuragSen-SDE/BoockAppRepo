package com.content.boockreaderapp.dashboard

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.content.boockreaderapp.navigation.AllBooksScreenRoute
import com.content.boockreaderapp.navigation.BookmarkedScreenRoute

@Composable
fun DashboardBottomNav(
    navController : NavHostController
){

    val items = listOf(
        AllBooksScreenRoute,
        BookmarkedScreenRoute
    )

    val currentDestination = navController.currentBackStackEntryAsState().value?.destination

    NavigationBar {
        items.forEach {
            route ->
            val isSelected = currentDestination?.hierarchy?.any{ it.hasRoute(route::class)} == true

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(route){
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = if (route == AllBooksScreenRoute) Icons.Default.Home else Icons.Default.Favorite,
                        contentDescription = null
                    )
                },
                label = {
                    Text( if (route == AllBooksScreenRoute) "All" else "Bookmarks")
                }
            )
        }
    }

}