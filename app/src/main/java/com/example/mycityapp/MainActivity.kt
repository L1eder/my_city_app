package com.example.mycityapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycityapp.data.datasource.RecommendationDataSource
import com.example.mycityapp.data.repository.RecommendationRepository
import com.example.mycityapp.presentation.screen.CategoryScreen
import com.example.mycityapp.presentation.screen.DetailsScreen
import com.example.mycityapp.presentation.screen.RecommendationsScreen
import com.example.mycityapp.presentation.viewmodel.CategoryViewModel
import com.example.mycityapp.presentation.viewmodel.DetailsViewModel
import com.example.mycityapp.presentation.viewmodel.RecommendationsViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val repository = RecommendationRepository(RecommendationDataSource())
            val categoryViewModel = CategoryViewModel(repository)
            val recommendationsViewModel = RecommendationsViewModel(repository)

            NavHost(navController = navController, startDestination = "categories") {
                composable("categories") {
                    CategoryScreen(navController, categoryViewModel.categories)
                }
                composable("recommendations/{categoryId}") { backStackEntry ->
                    val categoryId = backStackEntry.arguments?.getString("categoryId")?.toIntOrNull()
                    recommendationsViewModel.loadRecommendations(categoryId ?: 0)
                    RecommendationsScreen(navController, recommendationsViewModel, categoryId ?: 0)
                }
                composable("details/{categoryId}/{recommendationId}") { backStackEntry ->
                    val categoryId = backStackEntry.arguments?.getString("categoryId")?.toIntOrNull()
                    val recommendationId = backStackEntry.arguments?.getString("recommendationId")?.toIntOrNull()
                    val detailsViewModel = DetailsViewModel(repository)
                    if (categoryId != null && recommendationId != null) {
                        detailsViewModel.loadRecommendation(categoryId, recommendationId)
                    }
                    DetailsScreen(detailsViewModel)
                }
            }
        }
    }
}