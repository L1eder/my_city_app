package com.example.mycityapp.presentation.screen

import androidx.compose.runtime.Composable
import com.example.mycityapp.presentation.components.DetailsCard
import com.example.mycityapp.presentation.viewmodel.DetailsViewModel

@Composable
fun DetailsScreen(viewModel: DetailsViewModel) {
    val recommendation = viewModel.recommendation

    if (recommendation != null) {
        DetailsCard(
            imageResId = recommendation.imageResId,
            nameResId = recommendation.nameResId,
            descriptionResId = recommendation.descriptionResId
        )
    }
}