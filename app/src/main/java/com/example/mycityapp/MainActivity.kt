package com.example.mycityapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycityapp.data.datasource.RecommendationDataSource
import com.example.mycityapp.data.repository.RecommendationRepository
import com.example.mycityapp.navigation.Routes
import com.example.mycityapp.presentation.Background
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
            Background()
            NavHost(
                navController = navController,
                startDestination = Routes.CATEGORIES
            ) {
                composable(Routes.CATEGORIES) {
                    CategoryScreen(navController, categoryViewModel.categories)
                }
                composable(Routes.RECOMMENDATIONS) { backStackEntry ->
                    val categoryIdStr = backStackEntry.arguments?.getString("categoryId")
                    val categoryId = categoryIdStr?.toIntOrNull() ?: 0
                    recommendationsViewModel.loadRecommendations(categoryId)
                    RecommendationsScreen(navController, recommendationsViewModel, categoryId)
                }
                composable(Routes.DETAILS) { backStackEntry ->
                    val args = backStackEntry.arguments
                    val categoryIdStr = args?.getString("categoryId")
                    val recommendationIdStr = args?.getString("recommendationId")
                    val categoryId = categoryIdStr?.toIntOrNull() ?: 0
                    val recommendationId = recommendationIdStr?.toIntOrNull() ?: 0

                    val detailsViewModel = DetailsViewModel(repository)
                    if (categoryId != 0 && recommendationId != 0) {
                        detailsViewModel.loadRecommendation(categoryId, recommendationId)
                    }
                    DetailsScreen(detailsViewModel)
                }
            }
        }
    }
}