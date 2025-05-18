package com.example.mycityapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mycityapp.data.model.Recommendation
import com.example.mycityapp.data.repository.RecommendationRepository

class DetailsViewModel(private val repository: RecommendationRepository) : ViewModel() {
    var recommendation: Recommendation? = null
        private set

    fun loadRecommendation(categoryId: Int, recommendationId: Int) {
        recommendation = repository.getRecommendationById(categoryId, recommendationId)
    }
}