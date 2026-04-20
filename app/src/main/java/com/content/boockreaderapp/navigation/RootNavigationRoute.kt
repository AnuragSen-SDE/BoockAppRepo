package com.content.boockreaderapp.navigation

import com.content.boockreaderapp.data.lolcal.entity.BookEntity
import kotlinx.serialization.Serializable

@Serializable
object DashboardScreenRoute

@Serializable
data class BookDetailsRoute (
    val bookId : Int
)

@Serializable
data class BookReadingRoute (
    val bookId : Int
)

@Serializable
object SplashRoute

@Serializable
object AllBooksScreenRoute

@Serializable
object BookmarkedScreenRoute