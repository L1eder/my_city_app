package com.example.mycityapp.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.mycityapp.presentation.components.DetailsCard
import com.example.mycityapp.presentation.components.DetailsTitle
import com.example.mycityapp.presentation.viewmodel.DetailsViewModel

@Composable
fun DetailsScreen(viewModel: DetailsViewModel) {
    val recommendation = viewModel.recommendation

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    )
    {
        DetailsTitle()
        if (recommendation != null) {
            DetailsCard(
                imageResId = recommendation.imageResId,
                nameResId = recommendation.nameResId,
                descriptionResId = recommendation.descriptionResId
            )
        }
    }
}