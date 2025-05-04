package com.example.mycityapp.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.mycityapp.presentation.components.RecommendationCard
import com.example.mycityapp.presentation.viewmodel.RecommendationsViewModel

@Composable
fun RecommendationsScreen(navController: NavHostController, viewModel: RecommendationsViewModel, categoryId: Int) {
    viewModel.loadRecommendations(categoryId)

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(viewModel.recommendations) { recommendation ->
            RecommendationCard(recommendation) {
                navController.navigate("details/$categoryId/${recommendation.id}")
            }
        }
    }
}